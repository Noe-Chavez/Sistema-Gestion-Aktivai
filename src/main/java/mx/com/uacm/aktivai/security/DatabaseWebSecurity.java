package mx.com.uacm.aktivai.security;

import mx.com.uacm.aktivai.utilities.QuerysSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(QuerysSpringSecurity.QueryParaUsuario())
                .authoritiesByUsernameQuery(QuerysSpringSecurity.queryParaRolesPorUsuario());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // Los recursos estáticos no requieren autenticación
                .antMatchers(
                        "/images/**"
                ).permitAll()
                // Las vistas públicas no requieren autenticación (Por el momento todas requieren autenticación)
                .antMatchers().permitAll()
                // Asignar permisos a URLs por ROLES
                .antMatchers("/usuarios/**").hasAnyAuthority("Administrador")
                // Todas las demás URLs de la Aplicación requieren autenticación
                .anyRequest().authenticated()
                // El formulario de Login no requiere autenticacions
                .and().formLogin().permitAll();
    }
}
