drop database if exists project_control;
create database project_control;
use project_control;

drop table if exists project;
create table project
(
    project_num int primary key AUTO_INCREMENT,
    project_name varchar(20) unique ,
    project_man varchar(10) not null,
    project_location varchar(20) not null,
    project_budget varchar(10) not null
);

insert into project values(null, "孙悟空大闹天宫", "孙悟空", "天宫", "100000");
insert into project values(null, "孙悟空三打白骨精", "孙悟空", "山上", "13333");
insert into project values(null, "猪八戒背媳妇", "猪八戒", "高老庄", "233334");
insert into project values(null, "孙悟空大战狮驼岭", "孙悟空", "狮驼岭", "32123");
insert into project values(null, "唐僧情迷女儿国", "唐僧", "女儿国", "89898");
insert into project values(null, "唐僧与七个蜘蛛精之间的故事", "唐僧", "盘丝洞", "8977");
insert into project values(null, "真假美猴王", "孙悟空", "取经途中", "56634");
insert into project values(null, "猪八戒贪吃人参果", "猪八戒", "三清观", "99999");
insert into project values(null, "李岩考四级", "李岩", "陕西科技大学", "20");
insert into project values(null, "世举考大物", "世举", "陕西科技大学", "0");
insert into project values(null, "宏宇挂六级", "宏宇", "陕西科技大学", "20");
insert into project values(null, "陈苗去约会", "陈苗", "大雁塔", "40");
insert into project values(null, "李想约梦瑶", "李想", "咖啡厅", "30");
insert into project values(null, "世举打lol", "世举", "宿舍", "0");
insert into project values(null, "李岩在学习", "李岩", "宿舍", "0");
insert into project values(null, "世举在打牌", "世举", "实验室401", "0");