# JAVA_MA_TRAIN

Dự án này là một ví dụ **Spring Boot CRUD rất cơ bản** dành cho người mới bắt đầu học Java và Spring Boot.

## Mục tiêu học được

Khi đọc dự án này, bạn sẽ làm quen với:
- `@RestController`
- `@Service`
- `@Repository`
- DTO request/response
- Model và Enum
- Xử lý exception toàn cục
- Dữ liệu mẫu khi ứng dụng khởi động
- CRUD API cơ bản: tạo, đọc, cập nhật, xóa

## Chủ đề của dự án

Dự án xây dựng một API quản lý **Todo** (công việc cần làm).

Ví dụ:
- Học Java cơ bản
- Học Spring Boot
- Test API bằng Postman

## Cấu trúc 15 file Java mới

### 1) Model
- `todo/model/Todo.java`: đối tượng Todo chính
- `todo/model/TodoStatus.java`: trạng thái của Todo (`TODO`, `IN_PROGRESS`, `DONE`)

### 2) DTO
- `todo/dto/CreateTodoRequest.java`: dữ liệu nhận vào khi tạo Todo
- `todo/dto/UpdateTodoRequest.java`: dữ liệu nhận vào khi cập nhật Todo
- `todo/dto/TodoResponse.java`: dữ liệu trả về cho client

### 3) Repository
- `todo/repository/TodoRepository.java`: interface repository
- `todo/repository/InMemoryTodoRepository.java`: lưu dữ liệu trong bộ nhớ bằng `Map`

### 4) Business logic
- `todo/service/TodoService.java`: xử lý logic CRUD

### 5) Mapper và Validation
- `todo/mapper/TodoMapper.java`: chuyển đổi giữa model và DTO
- `todo/validation/TodoValidator.java`: kiểm tra dữ liệu đầu vào

### 6) Controller
- `todo/controller/TodoController.java`: các API CRUD cho Todo
- `todo/controller/AppInfoController.java`: API trang chủ `/`

### 7) Exception
- `todo/exception/TodoNotFoundException.java`: lỗi không tìm thấy Todo
- `todo/exception/GlobalExceptionHandler.java`: xử lý lỗi tập trung

### 8) Config
- `todo/config/SampleDataLoader.java`: tạo dữ liệu mẫu khi app khởi động

## Cách chạy project

### Chạy test
```powershell
.\gradlew.bat test
```

### Chạy ứng dụng
```powershell
.\gradlew.bat bootRun
```

> Nếu máy bạn đang bận cổng `8080`, có thể chạy cổng khác:

```powershell
.\gradlew.bat bootRun --args='--server.port=8081'
```

## API cơ bản

### 1. Xem trang hướng dẫn nhanh
```http
GET /
```

### 2. Xem tất cả Todo
```http
GET /api/todos
```

### 3. Xem chi tiết 1 Todo
```http
GET /api/todos/1
```

### 4. Tạo Todo mới
```http
POST /api/todos
Content-Type: application/json

{
  "title": "Học OOP",
  "description": "Tìm hiểu class, object, constructor"
}
```

### 5. Cập nhật Todo
```http
PUT /api/todos/1
Content-Type: application/json

{
  "title": "Học Spring Boot kỹ hơn",
  "description": "Tìm hiểu controller, service, repository",
  "status": "IN_PROGRESS"
}
```

### 6. Xóa Todo
```http
DELETE /api/todos/1
```

## Dữ liệu mẫu khi khởi động

Khi chạy ứng dụng, hệ thống sẽ tự tạo sẵn 3 Todo mẫu để bạn test nhanh.

## Gợi ý cách học dự án này

Thứ tự nên đọc:
1. `JavaMaTrainApplication.java`
2. `Todo.java`
3. `TodoStatus.java`
4. `CreateTodoRequest.java`, `UpdateTodoRequest.java`, `TodoResponse.java`
5. `TodoRepository.java`, `InMemoryTodoRepository.java`
6. `TodoService.java`
7. `TodoController.java`
8. `GlobalExceptionHandler.java`
9. `SampleDataLoader.java`

## Gợi ý bài tập tự luyện

Sau khi hiểu project này, bạn có thể tự thử:
- thêm field `deadline`
- thêm API tìm Todo theo trạng thái
- thêm API đánh dấu hoàn thành
- chuyển từ lưu trong bộ nhớ sang MySQL
- viết test cho controller và service

Chúc bạn học Spring Boot vui vẻ.

