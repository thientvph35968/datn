# Hướng dẫn test đăng nhập

## Các bước để test đăng nhập:

### 1. Khởi động ứng dụng
```bash
cd /workspace/datn
mvn spring-boot:run
```

### 2. Tạo user test
Truy cập: http://localhost:8080/test/create-test-user

### 3. Kiểm tra user đã tạo
Truy cập: http://localhost:8080/test/users

### 4. Test đăng nhập
Truy cập: http://localhost:8080/login
- Username: admin
- Password: 123456

### 5. Kiểm tra các trang sau khi đăng nhập
- http://localhost:8080/admin (cần role ADMIN)
- http://localhost:8080/ (trang chủ)

## Thông tin đăng nhập:
- **Username**: admin
- **Password**: 123456
- **Role**: ADMIN