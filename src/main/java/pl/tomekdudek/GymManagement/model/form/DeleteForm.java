package pl.tomekdudek.GymManagement.model.form;

import javax.validation.constraints.NotNull;

public class DeleteForm {

    @NotNull
    private int userId;

    public DeleteForm() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
