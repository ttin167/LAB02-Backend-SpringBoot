LINK VIDEO DEMO

https://drive.google.com/drive/folders/1eTH9_iOovnxBqPpIPFMY6oxzsjtUb_ki?usp=sharing

📌 Giới thiệu

LAB02-Backend-SpringBoot là một dự án backend sử dụng Spring Boot để xây dựng hệ thống quản lý dữ liệu. Dự án này được phát triển nhằm cung cấp API cho các ứng dụng frontend có thể kết nối và thực hiện các thao tác CRUD.

🛠️ Công nghệ sử dụng

Java 17

Spring Boot 3

Spring Data JPA

MySQL

Maven

📂 Cấu trúc thư mục
LAB02-Backend-SpringBoot/
│── .idea/                # Cấu hình IDE
│── .mvn/                 # Maven Wrapper
│── src/
│   ├── main/
│   │   ├── java/com/example/lab02/
│   │   │   ├── controller/        # Lớp điều khiển API
│   │   │   ├── entity/            # Các class entity ánh xạ database
│   │   │   ├── repository/        # Lớp truy cập dữ liệu
│   │   │   ├── service/           # Business logic
│   │   │   ├── Lab02Application.java # Điểm bắt đầu ứng dụng
│   │   ├── resources/              # File cấu hình ứng dụng
│   ├── test/                       # Unit test
│── pom.xml             # File cấu hình Maven
│── README.md           # Tài liệu dự án

🚀 Hướng dẫn chạy dự án
# Clone repository

git clone https://github.com/ttin167/LAB02-Backend-SpringBoot.git

cd LAB02-Backend-SpringBoot

# Build và chạy ứng dụng

🔥 API Endpoints

Method            Endpoint            Mô tả
GET               /api/items          Lấy danh sách items

POST              /api/items          Thêm một item mới

PUT               /api/items/{id}      Cập nhật item

DELETE            /api/items/{id}      Xóa item



 


