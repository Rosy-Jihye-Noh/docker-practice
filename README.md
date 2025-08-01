# 🐳 Docker 연습 프로젝트 모음

이 저장소는 Docker와 Docker Compose를 활용한 다양한 실습 프로젝트들을 모아둔 공간입니다. 각 프로젝트는 독립적으로 실행 가능하며, Docker 기초부터 고급 활용까지 단계별로 학습할 수 있습니다.

## 📋 목차
- [프로젝트 개요](#프로젝트-개요)
- [사전 요구사항](#사전-요구사항)
- [프로젝트별 상세 가이드](#프로젝트별-상세-가이드)
- [실행 방법](#실행-방법)
- [문제 해결](#문제-해결)
- [기여하기](#기여하기)

## 🎯 프로젝트 개요

| 프로젝트 | 기술 스택 | 난이도 | 설명 |
|---------|----------|--------|------|
| [docker-folder](#1-docker-folder) | Docker 기본 | ⭐ | Docker 기본 명령어 연습 |
| [docker-node-app](#2-docker-node-app) | Node.js + Express | ⭐⭐ | 단일 컨테이너 Node.js 앱 |
| [docker-compose-app](#3-docker-compose-app) | Node.js + Redis | ⭐⭐⭐ | 멀티 컨테이너 환경 |
| [docker-spring](#4-docker-spring) | Spring Boot + Oracle | ⭐⭐⭐⭐ | 엔터프라이즈급 애플리케이션 |

## 🔧 사전 요구사항

### 필수 설치 항목
- **Docker Desktop** (Windows/Mac) 또는 **Docker Engine** (Linux)
- **Docker Compose** (Docker Desktop에 포함됨)

### 선택 설치 항목
- **Node.js** (로컬 개발용)
- **Java 17** (Spring Boot 프로젝트 로컬 개발용)
- **Maven** (Spring Boot 프로젝트 빌드용)

### 설치 확인
```bash
# Docker 설치 확인
docker --version
docker-compose --version

# 선택사항 확인
node --version
java --version
mvn --version
```

## 📁 프로젝트별 상세 가이드

### 1. docker-folder
**Docker 기본 명령어 연습**

#### 📂 파일 구조
```
docker-folder/
└── Dockerfile
```

#### 🎯 학습 목표
- Docker 이미지 빌드
- 컨테이너 생성 및 실행
- 컨테이너 상태 확인
- 기본 Docker 명령어 숙지

#### 🚀 실행 방법
```bash
cd docker-folder

# 이미지 빌드
docker build -t my-alpine .

# 컨테이너 실행
docker run my-alpine

# 컨테이너 목록 확인
docker ps -a

# 이미지 목록 확인
docker images
```

---

### 2. docker-node-app
**Node.js 웹 서버 컨테이너화**

#### 📂 파일 구조
```
docker-node-app/
├── Dockerfile
├── package.json
└── server.js
```

#### 🎯 학습 목표
- Node.js 애플리케이션 컨테이너화
- 포트 매핑
- 볼륨 마운트
- 컨테이너 로그 확인

#### 🚀 실행 방법
```bash
cd docker-node-app

# 이미지 빌드
docker build -t node-counter-app .

# 컨테이너 실행 (포트 매핑)
docker run -p 8081:8081 node-counter-app

# 백그라운드 실행
docker run -d -p 8081:8081 --name node-app node-counter-app

# 로그 확인
docker logs node-app

# 컨테이너 중지
docker stop node-app
```

#### 🌐 접속 확인
브라우저에서 `http://localhost:8081` 접속
- 페이지 새로고침 시마다 카운터가 증가하는 것을 확인할 수 있습니다.

---

### 3. docker-compose-app
**멀티 컨테이너 환경 (Node.js + Redis)**

#### 📂 파일 구조
```
docker-compose-app/
├── docker-compose.yml
├── Dockerfile
├── package.json
└── index.js
```

#### 🎯 학습 목표
- Docker Compose를 이용한 멀티 컨테이너 관리
- 서비스 간 의존성 설정
- 네트워크 구성
- 환경 변수 활용

#### 🚀 실행 방법
```bash
cd docker-compose-app

# 모든 서비스 시작
docker-compose up -d

# 로그 확인
docker-compose logs

# 특정 서비스 로그 확인
docker-compose logs node-app

# 서비스 중지
docker-compose down

# 이미지까지 삭제
docker-compose down --rmi all
```

#### 🌐 접속 확인
브라우저에서 `http://localhost:5000` 접속
- Redis를 이용한 세션 관리 기능을 확인할 수 있습니다.

---

### 4. docker-spring
**Spring Boot + Oracle DB 엔터프라이즈 애플리케이션**

#### 📂 파일 구조
```
docker-spring/
├── docker-compose.yml
├── Dockerfile
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/docker_spring/
│       │       ├── Controller/
│       │       ├── service/
│       │       ├── mapper/
│       │       └── vo/
│       └── resources/
│           ├── application.yml
│           └── mapper/
└── target/
```

#### 🎯 학습 목표
- Spring Boot 애플리케이션 컨테이너화
- 데이터베이스 연동
- MyBatis를 이용한 데이터 접근
- 복잡한 멀티 서비스 환경 구성

#### 🚀 실행 방법
```bash
cd docker-spring

# 모든 서비스 시작 (Oracle DB + Spring Boot)
docker-compose up -d

# 로그 확인
docker-compose logs docker-spring

# 서비스 중지
docker-compose down

# 볼륨까지 삭제 (DB 데이터 초기화)
docker-compose down -v
```

#### 🌐 접속 확인
- Spring Boot 앱: `http://localhost:8081`
- Oracle DB: `localhost:1521` (SID: XE)

#### 📊 API 엔드포인트
- `GET /hello` - 기본 인사말
- `GET /members` - 회원 목록 조회
- `POST /members` - 회원 등록

---

## 🛠️ 실행 방법

### 전체 프로젝트 실행
```bash
# 1. 저장소 클론
git clone https://github.com/Rosy-Jihye-Noh/docker-practice.git
cd docker-practice

# 2. 원하는 프로젝트 폴더로 이동
cd [프로젝트명]

# 3. Docker 명령어 실행
# (각 프로젝트별 실행 방법 참조)
```

### 개발 모드 실행
```bash
# Node.js 프로젝트 (로컬 개발)
cd docker-node-app
npm install
node server.js

# Spring Boot 프로젝트 (로컬 개발)
cd docker-spring
mvn spring-boot:run
```

## 🔍 문제 해결

### 자주 발생하는 문제들

#### 1. 포트 충돌
```bash
# 사용 중인 포트 확인
netstat -ano | findstr :8081

# 다른 포트로 변경
docker run -p 8082:8081 node-counter-app
```

#### 2. 이미지 빌드 실패
```bash
# 캐시 없이 다시 빌드
docker build --no-cache -t my-app .

# Dockerfile 문법 확인
docker build --progress=plain -t my-app .
```

#### 3. 컨테이너 로그 확인
```bash
# 실시간 로그 확인
docker logs -f [컨테이너명]

# 마지막 100줄 로그 확인
docker logs --tail 100 [컨테이너명]
```

#### 4. 리소스 정리
```bash
# 사용하지 않는 컨테이너 삭제
docker container prune

# 사용하지 않는 이미지 삭제
docker image prune

# 전체 정리 (주의: 모든 컨테이너/이미지 삭제)
docker system prune -a
```

## 🤝 기여하기

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 라이선스

이 프로젝트는 교육 및 학습 목적으로 제작되었습니다.

## 👨‍💻 작성자

**Rosy-Jihye-Noh**
- GitHub: [@Rosy-Jihye-Noh](https://github.com/Rosy-Jihye-Noh)

---

⭐ 이 저장소가 도움이 되었다면 Star를 눌러주세요!
