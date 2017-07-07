DROP TABLE IF EXISTS Users;
CREATE TABLE Users(
  id INT AUTO_INCREMENT COMMENT '用户ID',
  username VARCHAR(32) NOT NULL UNIQUE COMMENT '账号',
  password VARCHAR(32) NOT NULL COMMENT '密码',
  name VARCHAR(32) NOT NULL COMMENT '用户姓名',
  phone VARCHAR(32) NOT NULL COMMENT '用户电话',
  identityNumber VARCHAR(32) NOT NULL COMMENT '用户身份证',
  role INT NOT NULL DEFAULT 0 COMMENT '权限级别',
  status VARCHAR(32) NOT NULL DEFAULT '未完成' COMMENT '学习状态',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

INSERT INTO Users(username, password,name, phone, .Users.identityNumber, role) VALUES ('admin', 'admin','系统管理员', '12345678912', 'identityNumber' ,5);