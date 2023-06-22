프로젝트 설정: Spring Boot를 사용하여 프로젝트를 생성하고, 필요한 의존성(Spring Web, Spring Data JPA, Thymeleaf, MySQL Driver 등)을 추가합니다.

데이터베이스 설정: MySQL에서 새 데이터베이스를 생성하고, Spring 애플리케이션의 application.properties 파일에 데이터베이스 연결 정보를 설정합니다.

도메인 모델 생성: 애플리케이션의 핵심 엔티티(예: 도서, 할 일, 레시피, 상품 등)와 관련된 클래스를 생성하고, 이들을 JPA 엔티티로 정의합니다.

리포지토리 생성: 각 엔티티에 대해 CRUD 연산을 수행하는 JPA 리포지토리를 생성합니다.

서비스 레이어 생성: 비즈니스 로직을 처리하는 서비스 클래스를 생성합니다. 이 클래스는 리포지토리를 사용하여 데이터베이스와 상호작용합니다.

컨트롤러 및 뷰 생성: 컨트롤러 클래스를 생성하여 HTTP 요청을 처리하고, Thymeleaf 템플릿을 사용하여 뷰를 생성합니다.

테스트 및 실행: 애플리케이션의 기능을 테스트하고, 실행하여 웹 브라우저에서 확인합니다.

package me.shinsunyoung.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Builder
    public User(String email, String password, String auth) {
        this.email = email;
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
