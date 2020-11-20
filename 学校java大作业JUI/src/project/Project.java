package project;

public class Project {

    private int project_num; //项目编号
    private String project_name;//项目名
    private String project_man;//
    private String project_location;
    private String project_budget;

    public int getProject_num() {
        return project_num;
    }

    public void setProject_num(int project_num) {
        this.project_num = project_num;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_man() {
        return project_man;
    }

    public void setProject_man(String project_man) {
        this.project_man = project_man;
    }

    public String getProject_location() {
        return project_location;
    }

    public void setProject_location(String project_location) {
        this.project_location = project_location;
    }

    public String getProject_budget() {
        return project_budget;
    }

    public void setProject_budget(String project_budget) {
        this.project_budget = project_budget;
    }

    @Override
    public String toString() {
        return "project{" +
                "project_num=" + project_num +
                ", project_name='" + project_name + '\'' +
                ", project_man='" + project_man + '\'' +
                ", project_location='" + project_location + '\'' +
                ", project_budget='" + project_budget + '\'' +
                '}';
    }
}

