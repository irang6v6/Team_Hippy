package net.skhu.model;

import lombok.Data;

@Data
public class Permission {
    boolean readGranted;
    boolean updateGranted;
    boolean createGranted;
    boolean deleteGranted;
}

