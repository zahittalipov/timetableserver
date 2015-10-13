package com.angelectro.zt.Tasks;

/**
 * Created by Zahit Talipov on 14.09.2015.
 */
public class TableTd {

    private String text;
    private int colspan;
    private int rowspan;
    public TableTd(String text, int rowspan,int colspan)
    {
        this.colspan=colspan;
        this.rowspan=rowspan;
        this.text=text;
    }

    public int getRowspan() {
        return rowspan;
    }

    public void setRowspan(int rowspan) {
        this.rowspan = rowspan;
    }

    public int getColspan() {
        return colspan;
    }

    public void setColspan(int colspan) {
        this.colspan = colspan;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
