# HƯỚNG DẪN DEBUG ĐĂNG NHẬP

## Bước 1: Khởi động ứng dụng
```bash
cd /workspace/datn
# Nếu có Maven:
mvn spring-boot:run

# Hoặc nếu có Java trực tiếp:
java -jar target/datn-0.0.1-SNAPSHOT.jar
```

## Bước 2: Test các endpoint debug
Sau khi khởi động, truy cập các URL sau:

### 2.1. Kiểm tra database
```
http://localhost:8080/debug/database
```
**Kết quả mong đợi:** "Database OK! Users: X, Roles: Y"

### 2.2. Kiểm tra tất cả user
```
http://localhost:8080/debug/users
```
**Kết quả mong đợi:** Danh sách JSON các user

### 2.3. Kiểm tra tất cả vai trò
```
http://localhost:8080/debug/roles
```
**Kết quả mong đợi:** Danh sách JSON các vai trò

### 2.4. Kiểm tra user admin
```
http://localhost:8080/debug/check-admin
```
**Kết quả mong đợi:** Thông tin chi tiết user admin

### 2.5. Tạo user admin đơn giản
```
http://localhost:8080/debug/create-simple-admin
```
**Kết quả mong đợi:** "Tạo admin user thành công! Username: admin, Password: 123456"

## Bước 3: Test đăng nhập
Sau khi tạo user admin:
```
http://localhost:8080/login
Username: admin
Password: 123456
```

## Bước 4: Nếu vẫn lỗi
Kiểm tra console log để xem lỗi cụ thể và báo lại cho tôi.