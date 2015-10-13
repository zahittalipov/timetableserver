package com.angelectro.zt.Tasks;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TimerTask;

/**
 * Created by Zahit Talipov on 13.10.2015.
 */
public class CheckingChanges extends TimerTask {
    LinkedList<LinkedList<TableTd>> table;
    Elements elements;
    @Override
    public void run() {

    }

    private void parseTable() throws IOException {
        Document doc = Jsoup.connect("URL").get();
        elements = doc.select("tr");
        for (int row = 0; row < elements.size(); row++) {
            LinkedList<TableTd> tableRow = new LinkedList<TableTd>();
            table.add(tableRow);
            Elements children = elements.get(row).children();
            for (int column = 0; column < children.size() - 3; column++) {
                Iterator<Attribute> attributeIterator = children.get(column).attributes().iterator();
                int colspan = 0;
                int rowspan = 0;
                while (attributeIterator.hasNext()) {
                    Attribute attribute = attributeIterator.next();
                    if (attribute.getKey().contains("colspan")) {
                        colspan = Integer.parseInt(attribute.getValue());
                        attribute.setValue("0");
                    }
                    if (attribute.getKey().contains("rowspan")) {
                        rowspan = Integer.parseInt(attribute.getValue());
                        attribute.setValue("0");
                    }
                }
                tableRow.add(new TableTd(children.get(column).text(), rowspan, colspan));

            }
            tableRow.removeFirst();
        }
    }

    private void parseSpan() {
        table.removeFirst();
        table.removeFirst();
        table.removeFirst();
        for (int i = 0; i < table.size(); i++) {
            LinkedList<TableTd> tds = table.get(i);
            for (int j = 0; j < tds.size(); j++) {
                TableTd tableTd = tds.get(j);
                if (i == 0) {
                    if (j == 0)
                        tableTd.setText("week");
                    if (j == 1)
                        tableTd.setText("time");
                }
                for (int colspan = 0; colspan < tableTd.getColspan() - 1; colspan++) {
                    tds.add(j + 1, new TableTd(tableTd.getText(), 0, 0));
                }
                for (int rowspan = 0; rowspan < tableTd.getRowspan() - 1; rowspan++) {
                    table.get(i + rowspan + 1).add(j, new TableTd(tableTd.getText(), 0, 0));
                }
            }
        }
    }
}
