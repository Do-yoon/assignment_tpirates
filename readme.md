# assignment
## Development Environment
* IDE: IntelliJ
* Java 11
* Build: Gradle
* API test: IntelliJ(generated-request.http), Insomnia(API test tool), Chrome

<br/>

## DB 구조
* store 테이블
  * id (INT, PRIMARY)
  * name (CHAR(20))
  * owner (CHAR(20))
  * description (TEXT(500), nullable)
  * level (INT)
  * address (CHAR(50))
  * phone (CHAR(13))

    
* holiday 테이블
  * id (INT, PRIMARY)
  * holiday (CHAR(10))
  

* businessTime 테이블
  * ID (INT, PRIMARY)
  * day (CHAR(10))
  * OPEN (TIME)
  * CLOSE (TIME)

## API
### A. 점포 추가 API
    아래 두 점포의 요청 파라미터를 전달 받아 DB 에 저장
    * 점포 등록시 id(Primary Key) 값은 자동 증가처리
    * 영업 시작 시간, 종료시간은 같을 수 없음


#### 상세설명
* Post
* Long addStore(StoreRegDTO storeRegDTO)
* /v0/store/addStore
* id 값 반환
<br/>
  


<br/>

### B. 점포 휴무일 등록 API
    영업일 외에 특별한 날을 휴무로 지정
    * 점포의 id(Primary Key) 값을 파라미터로 전달받아 저장
    * 요청 파라미터<br/>
      
    인어수산(id : 1)의 휴무일은 과제 마감일, 마감일+1 일(총 2 일)
    예) 과제 마감일이 4 월 30 일이라면 “2021-05-07”, “2021-05-08”


#### 상세설명
* Post
* Long regStoreHoliday(Long id, HolidayRegDTO holidays)
* url: /v0/store/regStoreHoliday/id\
* id 값 반환

<br/>

### C. 점포 목록 조회
    점포명, 점포 설명, 영업상태(영업중/영업종료/휴무) 정보를 등급(level)
    오름차순으로 조회
    # 영업 상태 조건값
        * 영업중(OPEN) : 영업 open time <= 현재시간 <= 영업 close time
        * 영업종료(CLOSE) : 현재시간 < 영업 open time, 현재시간 > 영업 close
          time
        * 휴무(HOLIDAY) : 오늘날짜가 해당 점포의 등록된 휴무일일 경우


#### 상세설명
* Get
* List\<StoreListDTO> getStoreList()
* url: /v0/store/storeList
* 전체 목록 조회 / 시간에 따른 영업 상태 반환 

<br/> 


### D. 점포 상세 조회 정보 API
    점포의 상세 정보(점포명, 점포 설명, 주소, 전화번호, 조회 일자 기준 영업시간 3
    일치)

#### 상세설명
* Get
* List\<StoreDetailDTO> getStoreDetail(Long id)
* url: /v0/store/storeDetails?id={id}
* 최근 3영업일 기준 조회 
* json 형태의 점포 정보 반환

<br/>


### E. 점포 삭제 API
    제휴가 종료된 점포에 대해 삭제 처리


#### 상세설명
* Delete(Post)
* Long deleteStore(Long id)
* url: /v0/store/deleteStore?id={id}
* id 값 반환
