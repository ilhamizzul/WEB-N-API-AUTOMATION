package api.models.Common;

import lombok.Data;

import java.util.List;

@Data
public class PaginatedResponse<T> {
    private List<T> data;
    private int total;
    private int page;
    private int limit;

    public List<T> getData() {
        return data;
    }
}
