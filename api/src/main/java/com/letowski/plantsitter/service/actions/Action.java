package com.letowski.plantsitter.service.actions;


public interface Action {

    void executeUnsafe() throws Exception;

    default void execute() {
        try {
            this.executeUnsafe();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default String getName() {
        return this.getClass().getSimpleName();
    }

}
