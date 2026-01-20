# 📜 Order Management System (OMS)

An Order Management System built with Spring Boot 3.x and Spring Security 6, designed to demonstrate multiple security mechanisms, clean architecture, and real-world backend practices.
---

## 🛠️ Tech Stack

- **Java 21**
- **Spring Boot 3.x**
- **Spring Security 6**
- **Spring Data JPA**
- **Hibernate**
- **Maven**
- **Lombok**
- **Thymeleaf**
- **Bootstrap 5.3.x** (Simple UI for testing security flows)
- **H2 / PostgreSQL** (switchable)
---

## 🎯 Project Goals

- Demonstrate modern Spring Security features in a realistic business domain
- Apply role-based and permission-based access control
- Implement multiple authentication strategies (form login, JWT, OAuth2)
- Showcase secure API and UI integration
- Serve as a reference project for interviews and real-world systems
---

## 🔐 Security Features Covered

- [ ] Form Login & Session-based authentication
- [x] HTTP Basic authentication (for APIs)
- [ ] Role-Based Access Control (RBAC)
- [ ] Permission-based authorization
- [ ] JWT Authentication & Authorization
- [ ] OAuth2 Login (Google / GitHub ready)
- [ ] OAuth2 Resource Server
- [ ] Method-level security
- [ ] @PreAuthorize
- [ ] @PostAuthorize
- [ ] CSRF protection
- [ ] CORS configuration
- [x] Secure password storage (BCrypt)
- [ ] Custom security filters
- [ ] Exception handling & access denial
---

## 🖥️ UI Purpose

The UI is intentionally **simple**, used mainly to:
- Test authentication flows
- Verify role-based access
- Demonstrate secured endpoints visually

> This is a **backend-focused project**, not a UI showcase.
---

## 🚀 Future Enhancements

- Split into microservices (Order, User, Auth)
- Secure inter-service communication
- API Gateway with centralized security
- Keycloak / external IdP integration
- Audit logging & security events
- Rate limiting & request throttling