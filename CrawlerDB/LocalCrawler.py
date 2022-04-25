from re import X
import requests
import time
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.common.exceptions import NoSuchElementException


# 헤드 정보 받아오기
headers = {'User-Agent' : 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36'}
driver = webdriver.Chrome(executable_path="C:\PJ\Team_Hippy\CrawlerDB\chromedriver.exe") # 프로젝트 폴더위치, 오류가 난다면 절대주소로 변경 default: ".\chromedriver"
url = 'https://www.herenow.city/ko/seoul/venue/'
driver.get(url)
data = requests.get(url,headers=headers)

## soup = BeautifulSoup(data.text, 'html.parser')
## Search_data = soup.find_all('div', class_='panel-title font--droidserif') bs4 레거시 코드

ul = driver.find_elements_by_xpath('//*[@id="pagetop"]/div[3]/main/div[1]/div[1]/section/div[3]/section/div[2]/div[2]/div[4]/div/div/ul/li[1]')
place_info = list()
place_id = 0
cnt = 0

# 각 페이지 정보 분석
for page_n in range(1, 7):
    url_herenow = 'https://www.herenow.city/ko/seoul/venue/page/%d'%(page_n)
    time.sleep(3)
    
    for x in range(0, 20):
        driver.get(url_herenow)       
        ## 예외처리 
        try:
            link = driver.find_element_by_xpath('//*[@id="pagetop"]/div[3]/main/div[1]/div[1]/section/div[3]/section/div[2]/div[2]/div[1]/ul/li[%d]/div/div/div/a' %(x+1))
        except NoSuchElementException:
            print("더이상 검색할 항목이 없습니다.")
            break
        else:
            link.click()
            
        place_name = driver.find_element_by_xpath('//*[@id="pagetop"]/div[3]/main/div/div/section/div/article/section/div[1]/div[2]/div[1]/h2')
        place_address = driver.find_element_by_xpath('//*[@id="pagetop"]/div[3]/main/div/div/section/div/article/section/div[2]/section/div[1]/div/dl[1]/dd')
        place_time = driver.find_element_by_xpath('//*[@id="pagetop"]/div[3]/main/div/div/section/div/article/section/div[2]/section/div[1]/div/dl[2]/dd')

        place_info.append([place_id ,place_name.text, place_address.text, place_time.text])
        print(place_info[place_id])
        place_id += 1
    

print("검색 완료")