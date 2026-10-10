package dev_java10x.peopleapi.service;

import dev_java10x.peopleapi.domain.Users;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

@ApplicationScoped 
public class UserService {

  private static final Logger LOG = Logger.getLogger(UserService.class);

  // Bloco transacional para garantir que a operação de persistência seja atômica
  @Transactional
  public Users createUser(Users users) {
    LOG.infof("Salvando usuário no banco: username=%s, email=%s", users.username, users.email);
    Users.persist(users);
    LOG.infof("Usuário salvo com id=%s", users.getId());
    return users;
  }
}
