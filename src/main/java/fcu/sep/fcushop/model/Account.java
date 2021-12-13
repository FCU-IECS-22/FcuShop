package fcu.sep.fcushop.model;

/**
 * this is class Product.
 */
public class Account {

  private long id;

  private String username;

  private String password;

  public Account() {
  }

  /**
   * Product init().
   *
   * @param id          id.
   * @param username    username.
   * @param password    password.
   */
  public Account(long id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
