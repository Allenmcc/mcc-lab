package fastJson;

/**
 * Created by chunchen.meng on 2019/8/8.
 */
public class ResopnseUser {
    private String resultcode;

    private String reason;

    private User2 result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public User2 getResult() {
        return result;
    }

    public void setResult(User2 result) {
        this.result = result;
    }
}
