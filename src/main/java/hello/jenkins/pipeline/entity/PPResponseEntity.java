package hello.jenkins.pipeline.entity;

public class PPResponseEntity {
    private String data;

    public PPResponseEntity(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
