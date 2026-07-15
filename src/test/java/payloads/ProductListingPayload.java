package payloads;

import java.util.List;

public class ProductListingPayload {

    private String type = "";
    private int page;
    private String min_price = "";
    private String max_price = "";
    private String selected_price_filter = "";
    private List<String> filters;
    private List<String> sort_by;
    private String categoryId = "";
    private String findMyFitFlag = "0";
    private String lens_width = "";
    private String bridge_width = "";
    private String temple_length = "";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getMin_price() {
        return min_price;
    }

    public void setMin_price(String min_price) {
        this.min_price = min_price;
    }

    public String getMax_price() {
        return max_price;
    }

    public void setMax_price(String max_price) {
        this.max_price = max_price;
    }

    public String getSelected_price_filter() {
        return selected_price_filter;
    }

    public void setSelected_price_filter(String selected_price_filter) {
        this.selected_price_filter = selected_price_filter;
    }

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    public List<String> getSort_by() {
        return sort_by;
    }

    public void setSort_by(List<String> sort_by) {
        this.sort_by = sort_by;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getFindMyFitFlag() {
        return findMyFitFlag;
    }

    public void setFindMyFitFlag(String findMyFitFlag) {
        this.findMyFitFlag = findMyFitFlag;
    }

    public String getLens_width() {
        return lens_width;
    }

    public void setLens_width(String lens_width) {
        this.lens_width = lens_width;
    }

    public String getBridge_width() {
        return bridge_width;
    }

    public void setBridge_width(String bridge_width) {
        this.bridge_width = bridge_width;
    }

    public String getTemple_length() {
        return temple_length;
    }

    public void setTemple_length(String temple_length) {
        this.temple_length = temple_length;
    }
}	