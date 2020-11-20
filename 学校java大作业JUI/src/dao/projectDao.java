package dao;

import connectDb.connectDb;
import exception.projectException;
import project.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class projectDao {

    //增加一个项目
    public void addProject(Project project) throws projectException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into project values (null, ?, ?, ?, ?)";
        connection = connectDb.getConnect();

        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,project.getProject_name());
            preparedStatement.setString(2,project.getProject_man());
            preparedStatement.setString(3,project.getProject_location());
            preparedStatement.setString(4,project.getProject_budget());

            int ret = preparedStatement.executeUpdate();

            if(ret !=1 ) {
                throw new projectException("插入数据失败");
            }

        } catch (SQLException e) {
            throw new projectException("插入数据失败");
        } finally {
            connectDb.getClose(connection, preparedStatement, null);
        }
    }

    //由项目编号删除河流
    public void deleteProject(int num) throws projectException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "delete from project where project_num = ?";
        connection = connectDb.getConnect();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, num);
            int ret = preparedStatement.executeUpdate();

            if(ret != 1) {
                throw new projectException("删除数据失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new projectException("删除数据失败");
        } finally {
            connectDb.getClose(connection, preparedStatement ,null);
        }
    }

    //由名字删除河流
    public void deleteProjectByName(String name) throws projectException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "delete from project where project_name = ?";
        connection = connectDb.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new projectException("删除数据失败！");
            }
        } catch (SQLException e) {
            throw new projectException("删除数据失败！");
        }finally {
            connectDb.getClose(connection,preparedStatement,null);
        }
    }

    //查找所有项目
    public List<Project> SelectAll() throws projectException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from project ";
        connection = connectDb.getConnect();

        List<Project> projectList = new ArrayList();
        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Project project = new Project() ;
                project.setProject_num(resultSet.getInt("project_num"));
                project.setProject_name(resultSet.getString("project_name"));
                project.setProject_man(resultSet.getString("project_man"));
                project.setProject_location(resultSet.getString("project_location"));
                project.setProject_budget(resultSet.getString("project_budget"));
                projectList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new projectException("查询所有河流信息失败！");

        }finally {
            connectDb.getClose(connection,preparedStatement,resultSet);
        }
        return projectList;

    }

    //由编号查找项目
    public Project selectByNum(int num) throws projectException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from project where project_num = ?";
        connection = connectDb.getConnect();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,num);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Project project = new Project() ;
                project.setProject_num(resultSet.getInt("project_num"));
                project.setProject_name(resultSet.getString("project_name"));
                project.setProject_man(resultSet.getString("project_man"));
                project.setProject_location(resultSet.getString("project_location"));
                project.setProject_budget(resultSet.getString("project_budget"));
                return project;

            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new projectException("按照num查找河流失败！");

        }finally {
            connectDb.getClose(connection,preparedStatement,resultSet);
        }
        return null;
    }


    //由名字查找具体的项目
    public Project selectByName(String name) throws projectException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from project where project_name = ?";
        connection = connectDb.getConnect();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Project project = new Project() ;
                project.setProject_num(resultSet.getInt("project_num"));
                project.setProject_name(resultSet.getString("project_name"));
                project.setProject_man(resultSet.getString("project_man"));
                project.setProject_location(resultSet.getString("project_location"));
                project.setProject_budget(resultSet.getString("project_budget"));
                return project;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new projectException("按照名字查找项目失败！");

        }finally {
            connectDb.getClose(connection,preparedStatement,resultSet);
        }
        return null;
    }


    //由名字更改项目位置
    public void updateProjectLocationByName(String name, String location) throws projectException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  project set  project_location = ? where project_name = ?";
        connection = connectDb.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,location);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new projectException("修改数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new projectException("修改数据失败！");
        }finally {
            connectDb.getClose(connection,preparedStatement,null);
        }
    }

    //由名字更改项目预算
    public void updateProjectBudgetByName(String name, String budget) throws projectException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update project set project_budget = ? where project_name = ?";
        connection = connectDb.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,budget);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new projectException("修改数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new projectException("修改数据失败！");
        }finally {
            connectDb.getClose(connection,preparedStatement,null);
        }
    }

    //由旧名字改新名字
    public void updateProjectNewNameByName(String name, String newName) throws projectException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update project set project_name = ? where project_name = ?";
        connection = connectDb.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,newName);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new projectException("修改数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new projectException("修改数据失败！");
        }finally {
            connectDb.getClose(connection,preparedStatement,null);
        }
    }

    //由名字更改河流的类型
    public void updateProjectManByName(String name, String man) throws projectException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  project set  project_man = ? where project_name = ?";
        connection = connectDb.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,man);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new projectException("修改数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new projectException("修改数据失败！");
        }finally {
            connectDb.getClose(connection,preparedStatement,null);
        }
    }

    //模糊查询所有项目
    public List<Project> findSomeProject(String name) throws projectException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from project where project_name like '%" + name + "%'";
        connection = connectDb.getConnect();

        List<Project> projectList = new ArrayList();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Project project = new Project() ;
                project.setProject_num(resultSet.getInt("project_num"));
                project.setProject_name(resultSet.getString("project_name"));
                project.setProject_man(resultSet.getString("project_man"));
                project.setProject_location(resultSet.getString("project_location"));
                project.setProject_budget(resultSet.getString("project_budget"));
                projectList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new projectException("查询所有项目信息失败！");

        }finally {
            connectDb.getClose(connection,preparedStatement,resultSet);
        }
        return projectList;

    }
}
