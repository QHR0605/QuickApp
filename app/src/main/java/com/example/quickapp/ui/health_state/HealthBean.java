package com.example.quickapp.ui.health_state;

import java.util.List;

public class HealthBean {
    private int status;
    private String message;
    private healthyMessage data;
    public static class healthyMessage {
        private String symptom;
        private String advice;
        private double score;

        public String getSymptom() {
            return symptom;
        }

        public void setSymptom(String symptom) {
            this.symptom = symptom;
        }

        public String getAdvice() {
            return advice;
        }

        public void setAdvice(String advice) {
            this.advice = advice;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public healthyMessage getData() {
        return data;
    }

    public void setData(healthyMessage data) {
        this.data = data;
    }
}
