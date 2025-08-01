# Docker 연습 프로젝트 모음

이 저장소는 Docker와 Docker Compose, 그리고 Spring Boot, Node.js 등 다양한 환경에서의 컨테이너 실습 프로젝트들을 모아둔 공간입니다.

## 폴더별 설명

### 1. docker-folder
- **목적:**  
  Docker 이미지 생성, 컨테이너 생성/실행/조회 등 Docker 기본 명령어 연습용 폴더입니다.
- **주요 파일:**  
  - `Dockerfile`
- **실습 예시:**  
  ```bash
  docker build -t my-alpine .
  docker run my-alpine
  docker ps -a
  ```

---

### 2. docker-compose-app
- **목적:**  
  Docker Compose를 이용한 멀티 컨테이너(예: Node.js + Redis) 환경 연습용 폴더입니다.
- **주요 파일:**  
  - `docker-compose.yml`
  - `Dockerfile`
  - `index.js`, `package.json`
- **실습 예시:**  
  ```bash
  docker-compose up -d
  # 브라우저에서 localhost:5000 접속
  ```

---

### 3. docker-node-app
- **목적:**  
  Node.js 웹 서버를 Docker로 빌드 및 실행하는 연습용 폴더입니다.  
  사이트 접속 시마다 조회수가 증가하는 간단한 예제입니다.
- **주요 파일:**  
  - `Dockerfile`
  - `server.js`, `package.json`
- **실습 예시:**  
  ```bash
  docker build -t node-app .
  docker run -p 8081:8081 node-app
  # 브라우저에서 localhost:8081 접속
  ```

---

### 4. docker-spring
- **목적:**  
  Spring Boot 애플리케이션을 Docker 이미지로 빌드하고, 오라클 DB와 연동하여 컨테이너로 실행하는 연습용 폴더입니다.
- **주요 파일:**  
  - `Dockerfile`
  - `docker-compose.yml`
  - `pom.xml`, `src/`
- **실습 예시:**  
  ```bash
  docker-compose up -d
  # 브라우저에서 localhost:8081/hello 등 접속
  ```

---

## 공통 참고사항

- 각 폴더별로 독립적으로 실습 가능합니다.
- 실습 전 Docker, Docker Compose, (필요시) Node.js, Java, Maven 등이 설치되어 있어야 합니다.
- 각 폴더의 `Dockerfile` 또는 `docker-compose.yml`을 참고하여 명령어를 실행하세요.

---

## 라이선스

이 저장소는 교육 및 연습 목적입니다.
