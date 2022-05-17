package net.skhu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import net.skhu.config.ModelMapperConfig.MyModelMapper;
import net.skhu.config.MyUserDetails;
import net.skhu.entity.User;
import net.skhu.entity.UserRole;
import net.skhu.model.Pagination;
import net.skhu.model.UserDto;
import net.skhu.model.UserEdit;
import net.skhu.model.UserSignUp;
import net.skhu.repository.UserRepository;
import net.skhu.repository.UserRoleRepository;

@Service
public class UserService {

    @Autowired UserRepository userRepository;
    @Autowired UserRoleRepository userRoleRepository;
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired MyModelMapper modelMapper;

    public UserEdit findById(int id) {
        var userEntity = userRepository.findById(id).get();
        var userEdit = modelMapper.map(userEntity, UserEdit.class);
        List<UserRole> userRole = userEntity.getUserRoles();
        String[] roles = userRole.stream().map(UserRole::getRole).toArray(String[]::new);
        userEdit.setRoles(roles);
        return userEdit;
    }

    public boolean hasErrors(UserSignUp userSignUp, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return true;
        if (userSignUp.getPasswd1().equals(userSignUp.getPasswd2()) == false) {
            bindingResult.rejectValue("passwd2", null, "비밀번호가 일치하지 않습니다.");
            return true;
        }
        User user = userRepository.findByLoginName(userSignUp.getLoginName());
        if (user != null) {
            bindingResult.rejectValue("loginName", null, "사용자 아이디가 중복됩니다.");
            return true;
        }
        return false;
    }

    public boolean hasErrors(UserEdit userEdit, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return true;
        User user = userRepository.findByLoginName(userEdit.getLoginName());
        if (user != null && user.getId() != userEdit.getId()) {
            bindingResult.rejectValue("loginName", null, "사용자 아이디가 중복됩니다.");
            return true;
        }
        return false;
    }

    public void save(UserSignUp userSignUp) {
        User user = modelMapper.map(userSignUp, User.class);
        user.setPassword(passwordEncoder.encode(userSignUp.getPasswd1()));
        userRepository.save(user);
    }

    @Transactional
    public void save(UserEdit userEdit) {
        User user = userRepository.findById(userEdit.getId()).get();
        user.setLoginName(userEdit.getLoginName());
        user.setName(userEdit.getName());
        user.setEmail(userEdit.getEmail());
        user.setEnabled(userEdit.isEnabled());
        userRoleRepository.deleteByUserId(user.getId());
        for (String role : userEdit.getRoles()) {
            var userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);
            userRoleRepository.save(userRole);
        }
        userRepository.save(user);
    }

    private static Sort[] orderBy = new Sort[] {
        Sort.by(Sort.Direction.DESC, "id"),
        Sort.by(Sort.Direction.DESC, "id"),
        Sort.by(Sort.Direction.ASC, "loginName"),
        Sort.by(Sort.Direction.ASC, "name")
    };

    public List<UserDto> findAll(Pagination pagination) {
        int pg = pagination.getPg() - 1, sz = pagination.getSz(),
            si = pagination.getSi(), od = pagination.getOd();
        String st = pagination.getSt();
        Page<User> page = null;
        if (si == 1)
            page = userRepository.findByLoginNameStartsWith(st, PageRequest.of(pg, sz, orderBy[od]));
        else if (si == 2)
            page = userRepository.findByNameStartsWith(st, PageRequest.of(pg, sz, orderBy[od]));
        else
            page = userRepository.findAll(PageRequest.of(pg, sz, orderBy[od]));
        pagination.setRecordCount((int)page.getTotalElements());
        List<User> userEntities = page.getContent();
        List<UserDto> userDtos = modelMapper.mapList(userEntities, UserDto.class);
        for (int i = 0; i < userDtos.size(); ++i) {
            User user = userEntities.get(i);
            List<UserRole> userRoles = user.getUserRoles();
            String[] roles = userRoles.stream().map(UserRole::getRole).toArray(String[]::new);
            userDtos.get(i).setRoles(roles);
        }
        return userDtos;
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User getCurrentUser() {
        var myUserDetail = (MyUserDetails)SecurityContextHolder.getContext()
                                                               .getAuthentication().getPrincipal();
        return myUserDetail.getUser();
    }
}
