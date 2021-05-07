# assignment
## Development Environment
* IDE: IntelliJ
* Java 11
* Build: Gradle

## API
### A. 점포 추가 API
아래 두 점포의 요청 파라미터를 전달 받아 DB 에 저장
* 점포 등록시 id(Primary Key) 값은 자동 증가처리
* 영업 시작 시간, 종료시간은 같을 수 없음

메소드 상세설명
* Post
* boolean addStore(String name, String owner, String description, int level, String addr, String phone, BusinessTime[] businessTimes)
* 모두 필수 파라미터

### B. 점포 휴무일 등록 API
영업일 외에 특별한 날을 휴무로 지정
* 점포의 id(Primary Key) 값을 파라미터로 전달받아 저장
* 요청 파라미터<br/>
  
        인어수산(id : 1)의 휴무일은 과제 마감일, 마감일+1 일(총 2 일)
        예) 과제 마감일이 4 월 30 일이라면 “2021-05-07”, “2021-05-08”

메소드 상세설명
* Post
* boolean regStoreHoliday(int id, Date[] holidays)
* 모두 필수 파라미터

### C. 점포 목록 조회
점포명, 점포 설명, 영업상태(영업중/영업종료/휴무) 정보를 등급(level)
오름차순으로 조회
* 영업 상태 조건값
    * 영업중(OPEN) : 영업 open time <= 현재시간 <= 영업 close time
    * 영업종료(CLOSE) : 현재시간 < 영업 open time, 현재시간 > 영업 close
      time
    * 휴무(HOLIDAY) : 오늘날짜가 해당 점포의 등록된 휴무일일 경우
    
메소드 상세설명
* Get
* List\<StoreSummary> getStoreList()
    
### D. 점포 상세 조회 정보 API
점포의 상세 정보(점포명, 점포 설명, 주소, 전화번호, 조회 일자 기준 영업시간 3
일치)

메소드 상세설명
* Get
* List\<Store> getStoreDetail()


### E. 점포 삭제 API
제휴가 종료된 점포에 대해 삭제 처리

메소드 상세설명
* Delete(Post)
* boolean deleteStore(int id)