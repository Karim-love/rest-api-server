# ๐ rest-api-server
```
>> spring boot gradle version
spring boot : 2.6.1
```
## โ spring Boot ๋์์ ๋ํ ๊ธฐ๋ณธ ๊ธฐ๋ฅ
spring Boot ์ ๊ธฐ๋ณธ ๋์์ ๊ณต๋ถํ๊ธฐ ์ํด ๊ฐ๋จํ api server ๋ฅผ ๊ตฌํํ ํ๋ก์ ํธ ์๋๋ค.

## โ๏ธ๊ธฐ๋ฅ๋ณ ์ ๋ฆฌ
<details close>
<summary markdown="span"><b> ๐ ์ค๋ช</b></summary>
<div markdown="1">

### 1. vault
- `/api/v1/vault` ์์ฒญ ์ vault ์๋ฒ์ ์๋ ๊ณ์  ์ ๋ณด๋ฅผ ์ ๋ฌํ๋ค.

### 2. DB User table control
- DB user info insert
  + `/api/v2/TableName/setUser -d "{"userId":"์ฌ์ฉ์Id","userPw":"์ฌ์ฉ์Pw","userName":"์ฌ์ฉ์Name"}"`
  + Method : setUser
  + ์์ฒญ ์ ์๋ฒ์ ํด๋น body ์ ๋ณด๋ฅผ ์ ์ฅํ๋ค.

- DB user info select all
  + `/api/v2/TableName/getUserAll`
  + Method : getUserAll
  + ์์ฒญ ์ ์๋ฒ์ ํด๋น ํ์ด๋ธ User ์ ๋ณด๋ฅผ ๋ชจ๋ ์กฐํํ๋ค.

### 3. ehCache DB User table control 
- ehCache DB user info select all
  + `/api/v2/cache/TableName/getUserAll`
  + Method : getUserAll
  + ์์ฒญ ์ ์๋ฒ์ ํด๋น ํ์ด๋ธ User ์ ๋ณด๋ฅผ ๋ชจ๋ ์กฐํ ๋ฐ ehCache์ ์ ์ฅํ๋ค.
  
- ehCache DB user info clear all
  + `/api/v2/cache/refresh`
  + Method : refresh
  + ์์ฒญ ์ ehCache์ ์๋ ๋ฐ์ดํฐ๋ฅผ clear ํ๋ค.

</div>
</details>


## โ๏ธPakage ๋ณ ์ ๋ฆฌ
<details close>
<summary markdown="span"><b> ๐ ์ค๋ช</b></summary>
<div markdown="1">

### 1. utils
- ๊ธฐ๋ณธ ๊ธฐ๋ฅ์ ์ ๊ณตํ๋ ๋ถ์ ๊ธฐ๋ฅ ๋ฐ ์ ํธ ๋ชจ์

### 2. configuration
- Spring ์ค์ ์ด ์๋ pkg

### 3. controller
- ์์ฒญ์ ์ ๋ดํ๋ ์ปจํธ๋กค๋ฌ ๋ชจ์

### 4. maria
#### 4-1. mapper
- Mybatis ๋งคํ xml์ ๊ธฐ์ฌ๋ sql๋ฅผ ํธ์ถํ๊ธฐ ์ํ ์ธํฐํ์ด์ค ๋ชจ์
#### 4-2. vo
- DB์์ ์กฐํํ ์ ๋ณด๋ฑ์ด ์๋ vo ๋ชจ์

### 5. service
- ๋น์ฆ๋์ค ๋ก์ง ์ํ ์๋น์ค ๋ชจ์

### 6. global
- Instance ๋ฐ Object ๋ชจ์

</div>
</details>

## โ๏ธResources ๋ณ ์ ๋ฆฌ
<details close>
<summary markdown="span"><b> ๐ ์ค๋ช</b></summary>
<div markdown="1">

### 1. query
- mapper ์์ ์ฌ์ฉํ  sql ๋ชจ์

### 2. static
- content ํ์ผ ๋ชจ์ (css, js)

### 3. templates
- thymeleaf ํ์ผ ๋ชจ์

</div>
</details>
