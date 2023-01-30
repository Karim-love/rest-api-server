# 📃 rest-api-server
```
>> spring boot gradle version
spring boot : 2.6.1
```
## ❓ spring Boot 동작에 대한 기본 기능
spring Boot 의 기본 동작을 공부하기 위해 간단한 api server 를 구현한 프로젝트 입니다.

## ✔️기능별 정리
📌 설명

1. vault
- `/api/v1/vault` 요청 시 vault 서버에 있는 계정 정보를 전달한다.

2. DB User table control
- DB user info insert
  + `/api/v2/TableName/setUser -d "{"userId":"사용자Id","userPw":"사용자Pw","userName":"사용자Name"}"`
  + Method : setUser
  + 요청 시 서버에 해당 body 정보를 저장한다.

- DB user info select all
  + `/api/v2/TableName/getUserAll`
  + Method : getUserAll
  + 요청 시 서버에 해당 테이블 User 정보를 모두 조회한다.

3. ehCache DB User table control 
- ehCache DB user info select all
  + `/api/v2/cache/TableName/getUserAll`
  + Method : getUserAll
  + 요청 시 서버에 해당 테이블 User 정보를 모두 조회 및 ehCache에 저장한다.
  
- ehCache DB user info clear all
  + `/api/v2/cache/refresh`
  + Method : refresh
  + 요청 시 ehCache에 있는 데이터를 clear 한다.


## ✔️Pakage 별 정리
📌 설명

```bash
📦src
┗ 📂restApiServer
┃ ┣ 📂aop
┃ ┃ ┗ 📜 AOP 기능 모음
┃ ┣ 📂configuration
┃ ┃ ┗ 📜 Spring 설정이 있는 pkg
┃ ┣ 📂controller
┃ ┃ ┗ 📜 요청을 전담하는 컨트롤러 모음
┃ ┣ 📂domain
┃ ┃ ┗ 📜 VO 객체 모음
┃ ┣ 📂global
┃ ┃ ┗ 📜 Instance 및 Object 모음
┃ ┣ 📂repository
┃ ┃ ┣ 📂mapper
┃ ┃ ┃ ┗ 📜 Mybatis 매핑 xml에 기재된 sql를 호출하기 위한 인터페이스 모음
┃ ┃ ┗ 📜 데이터 조작 관련 인터페이스 및 해당 인터페이스 구현체 모음
┃ ┣ 📂service
┃ ┃ ┗ 📜 비즈니스 로직 수행 서비스 모음
┃ ┣ 📂utils
┃ ┃ ┗ 📜 본 기능을 제공하는 부속 기능 및 유틸 모음
┃ ┗ 📜 SpringConfig.java
┃ ┗ 📜 WebApplication.java
┗ 📂resources
┃ ┣ 📂query
┃ ┃ ┗ 📜 mapper 에서 사용할 sql 모음
┗ ┗ 📜 project 설정 모음
```