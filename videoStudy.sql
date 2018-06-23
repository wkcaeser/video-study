CREATE TABLE Users(
  id INT AUTO_INCREMENT COMMENT '用户ID',
  username VARCHAR(32) NOT NULL UNIQUE COMMENT '账号',
  password VARCHAR(32) NOT NULL COMMENT '密码',
  name VARCHAR(32) NOT NULL COMMENT '用户姓名',
  phone VARCHAR(32) NOT NULL COMMENT '用户电话',
  sex VARCHAR(8) NOT NULL COMMENT '性别',
  identityNumber VARCHAR(32) NOT NULL COMMENT '用户身份证',
  company VARCHAR(32) COMMENT '所属公司',
  role INT NOT NULL DEFAULT 0 COMMENT '权限级别',
  status VARCHAR(32) NOT NULL DEFAULT '未完成' COMMENT '学习状态',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

INSERT INTO Users(username, password,name, phone, sex, identityNumber, role, company) VALUES ('admin', 'admin','系统管理员', '12345678912', '男',  'identityNumber' ,5, '学习平台');

CREATE TABLE ClassList(
  id INT AUTO_INCREMENT COMMENT '编号',
  name VARCHAR(128) NOT NULL COMMENT '课程名称',
  type VARCHAR(32) NOT NULL COMMENT '课程类型',
  price INT NOT NULL COMMENT '课程价格',
  time INT COMMENT '学时',
  img INT COMMENT '图标',
  PRIMARY KEY (id),
  FOREIGN KEY (img) REFERENCES Img(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程列表';

INSERT INTO ClassList(name, type, price) VALUES ('食品安全知识法规详解(职员课程)', '题库', '300');
INSERT INTO ClassList(name, type, price) VALUES ('食品安全知识法规详解(管理课程)', '题库', '600');

CREATE TABLE ClassPay(
  id INT AUTO_INCREMENT COMMENT '编号',
  number INT NOT NULL DEFAULT 1 COMMENT '购买数量',
  classId INT NOT NULL COMMENT '课程id',
  uid INT NOT NULL COMMENT '购买人',
  time DATETIME NOT NULL COMMENT '购买时间',
  status INT DEFAULT 0 COMMENT '状态',
  PRIMARY KEY (id),
  FOREIGN KEY (classId) REFERENCES ClassList(id),
  FOREIGN KEY (uid) REFERENCES Users(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程购买记录';

CREATE TABLE License(
  id INT AUTO_INCREMENT COMMENT '编号',
  uid INT NOT NULL COMMENT '用户id',
  status INT DEFAULT 0 COMMENT '发放状态',
  time DATETIME COMMENT '时间',
  score INT COMMENT '分数',
  PRIMARY KEY (id),
  FOREIGN KEY (uid) REFERENCES Users(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='证书记录';

CREATE TABLE QuestionInfo(
  id INT AUTO_INCREMENT COMMENT '编号',
  description VARCHAR(256) NOT NULL COMMENT '题库描述',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题库分类表';

INSERT INTO QuestionInfo(description) VALUES ('《中华人民共和国食品安全法》');
INSERT INTO QuestionInfo(description) VALUES ('《中华人民共和国食品安全法实施条例》');
INSERT INTO QuestionInfo(description) VALUES ('《湖北省食品安全条例》');
INSERT INTO QuestionInfo(description) VALUES ('《国务院关于加强食品等产品安全监督管理的特别规定》');
INSERT INTO QuestionInfo(description) VALUES ('《食品生产许可管理办法》');
INSERT INTO QuestionInfo(description) VALUES ('《食品经营许可管理办法》');
INSERT INTO QuestionInfo(description) VALUES ('《食品安全抽样检验管理办法》');
INSERT INTO QuestionInfo(description) VALUES ('《食品召回管理办法》');
INSERT INTO QuestionInfo(description) VALUES ('《乳品质量安全监督管理条例》');
INSERT INTO QuestionInfo(description) VALUES ('《食品标识管理规定》');
INSERT INTO QuestionInfo(description) VALUES ('《餐饮服务食品安全监督管理办法》');
INSERT INTO QuestionInfo(description) VALUES ('《餐饮服务食品安全监督抽样工作规范》');
INSERT INTO QuestionInfo(description) VALUES ('《餐饮服务食品安全操作规范》');

CREATE TABLE Question(
  id INT AUTO_INCREMENT COMMENT '编号',
  description VARCHAR(256) NOT NULL COMMENT '问题描述',
  answerA VARCHAR(128) NOT NULL COMMENT '选项A',
  answerB VARCHAR(128) NOT NULL COMMENT '选项B',
  answerC VARCHAR(128) NOT NULL COMMENT '选项C',
  answerD VARCHAR(128) COMMENT '选项D',
  answer VARCHAR(4) NOT NULL COMMENT '正确答案',
  parent INT NOT NULL COMMENT '题目类别',
  PRIMARY KEY (id),
  FOREIGN KEY (parent) REFERENCES QuestionInfo(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题库';

CREATE TABLE QuestionStudyLog(
  qid INT COMMENT '题库id',
  uid INT COMMENT '用户id',
  PRIMARY KEY (qid, uid),
  FOREIGN KEY (qid) REFERENCES QuestionInfo(id),
  FOREIGN KEY (uid) REFERENCES Users(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题库学习记录';

CREATE TABLE QuestionStudyTimeLog(
  qid INT COMMENT '题库id',
  uid INT COMMENT '用户id',
  time INT NOT NULL COMMENT '学习时长/分',
  date DATETIME NOT NULL COMMENT 'log时间',
  FOREIGN KEY (qid) REFERENCES QuestionInfo(id),
  FOREIGN KEY (uid) REFERENCES Users(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题库学习时间记录';

CREATE TABLE Score(
  uid INT COMMENT '用户id',
  score INT NOT NULL COMMENT '考试分数',
  date DATETIME NOT NULL COMMENT '考试时间',
  FOREIGN KEY (uid) REFERENCES Users(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题库学习时间记录';

CREATE VIEW PayDetail
  AS
  SELECT t1.id as id, t1.classId as classId, t2.id as uid, t1.time as time,
    t3.name as className, t3.price as price,
    t1.status as status,  t2.name as uname
  FROM ClassPay t1
  LEFT JOIN Users t2 ON t1.uid = t2.id
  LEFT JOIN ClassList t3 ON t1.classId = t3.id;

CREATE VIEW LicenseDetail
  AS
  SELECT t1.id AS id, t1.time AS time, t1.status AS status, t1.score AS score, t2.name AS name, t2.phone AS phone
  FROM License t1
  LEFT JOIN Users t2 ON t1.uid = t2.id

