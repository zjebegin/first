DROP TABLE IF EXISTS auth_users;
DROP TABLE IF EXISTS auth_roles;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS auth_menu;

CREATE  TABLE auth_users (
  user_id INT(10) NOT NULL auto_increment,
  user_name VARCHAR(100) NOT NULL ,
  password VARCHAR(100) NOT NULL ,
  enabled boolean NOT NULL ,
  create_time TimeStamp,
  update_time TimeStamp,
  PRIMARY KEY (user_id));
CREATE  TABLE auth_roles (
  role_id INT(10) NOT NULL auto_increment,
  role_code VARCHAR(100) NOT NULL ,
  role_name VARCHAR(100) NOT NULL ,
  remark VARCHAR(200) ,
  create_time TimeStamp,
  update_time TimeStamp,
  PRIMARY KEY (role_id));

CREATE  TABLE user_role (
  id INT(10) NOT NULL auto_increment,
  user_id INT(10) NOT NULL ,
  role_id INT(10) NOT NULL ,
  create_time TimeStamp,
  update_time TimeStamp,
  PRIMARY KEY (id),
  foreign key(user_id) references auth_users(user_id),
  foreign key(role_id) references auth_roles(role_id));

CREATE  TABLE auth_menu (
  menu_id INT(10) NOT NULL auto_increment,
  parent_id INT(10) ,
  menu_name VARCHAR(100) NOT NULL ,
  menu_url VARCHAR(256),
  remark VARCHAR(200) ,
  create_time TimeStamp,
  update_time TimeStamp,
  PRIMARY KEY (menu_id));

INSERT INTO auth_users(user_name,password,enabled,create_time,update_time)
VALUES ('test1','123456', true,current_timestamp(),current_timestamp());
INSERT INTO auth_users(user_name,password,enabled,create_time,update_time)
VALUES ('test2','123456', true,current_timestamp(),current_timestamp());


INSERT INTO auth_roles(role_code,role_name,create_time,update_time)
VALUES ('ADMIN','管理员', current_timestamp(),current_timestamp());
INSERT INTO auth_roles(role_code,role_name,create_time,update_time)
VALUES ('USER','普通用户', current_timestamp(),current_timestamp());

INSERT INTO user_role(user_id,role_id,create_time,update_time)
VALUES ('1','1', current_timestamp(),current_timestamp());
INSERT INTO user_role(user_id,role_id,create_time,update_time)
VALUES ('2','2', current_timestamp(),current_timestamp());

INSERT INTO auth_menu(menu_name,menu_url,create_time,update_time)
VALUES ('用户管理','/userPage', current_timestamp(),current_timestamp());
INSERT INTO auth_menu(menu_name,menu_url,create_time,update_time)
VALUES ('角色管理','/rolePage', current_timestamp(),current_timestamp());
INSERT INTO auth_menu(menu_name,menu_url,create_time,update_time)
VALUES ('菜单管理','/menuPage', current_timestamp(),current_timestamp());

-----------------------------------------------------------------------
DROP TABLE IF EXISTS oauth_client_details;
create table oauth_client_details (
    client_id VARCHAR(256) PRIMARY KEY,
    resource_ids VARCHAR(256),
    client_secret VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256)
);
INSERT INTO oauth_client_details
    (client_id, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove)
VALUES
    ('user-client', '123456', 'all',
    '"authorization_code","refresh_token","password"', 'http://localhost:8081', null, 3600, 36000, null, true);

INSERT INTO oauth_client_details
    (client_id, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove)
VALUES
    ('music-client', '123456', 'all',
    'authorization_code,refresh_token,password', 'http://localhost:8081', null, 3600, 36000, null, true);
