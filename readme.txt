https://www.bezkoder.com/spring-boot-security-login-jwt/

# Build a Spring Boot, Spring Security: Login and Registration that supports JWT with HttpOnly Cookie working w/ H2 Database.

-User can signup new account(registration), login with username & password
-User's role (admin, moderator, user). we authorize the user to access resources.

APIs

Methods	Urls	Actions
POST	/api/auth/signup	signup new account
POST	/api/auth/signin	login an account
POST	/api/auth/signout	logout the account
GET	/api/test/all	retrieve public content
GET	/api/test/user	access User’s content
GET	/api/test/mod	access Moderator’s content
GET	/api/test/admin	access Admin’s content

## Project Structure
(https://www.bezkoder.com/wp-content/uploads/2022/01/spring-boot-security-login-example-jwt-project-structure.png)

security: we configure Spring Security & implement Security Objects here.

WebSecurityConfig extends WebSecurityConfigurerAdapter
(WebSecurityConfigurerAdapter is deprecated from Spring 2.7.0, you can check the source code for update. More details at:
WebSecurityConfigurerAdapter Deprecated in Spring Boot)

UserDetailsServiceImpl implements UserDetailsService
UserDetailsImpl implements UserDetails
AuthEntryPointJwt implements AuthenticationEntryPoint
AuthTokenFilter extends OncePerRequestFilter
JwtUtils provides methods for generating, parsing, validating JWT
controllers handle signup/login requests & authorized requests.

AuthController: @PostMapping(‘/signup’), @PostMapping(‘/signin’), @PostMapping(‘/signout’)
TestController: @GetMapping(‘/api/test/all’), @GetMapping(‘/api/test/[role]’)
repository has interfaces that extend Spring Data JPA JpaRepository to interact with Database.

UserRepository extends JpaRepository<User, Long>
RoleRepository extends JpaRepository<Role, Long>
models defines two main models for Authentication (User) & Authorization (Role). They have many-to-many relationship.

User: id, username, email, password, roles
Role: id, name
payload defines classes for Request and Response objects
