package hikuley.api.response;

import java.util.List;

public class ResponseOfGetList<T> extends BaseApiResponse {
    private final List<T> resultList;

    public ResponseOfGetList(List<T> list) {
        this.resultList = list;
    }

    public List<T> getList() {
        return this.resultList;
    }
}
