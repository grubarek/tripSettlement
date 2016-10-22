package pl.agh.id.tripsettlement.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringConverter {

    public static List<String> convertStringToStringList(String s) {
        return Lists.newArrayList(Splitter.on(",").split(s));
    }

    public static List<Long> convertStringToLongList(String s) throws NumberFormatException {

        List<Long> longList = new ArrayList<>();
        if (StringUtils.isNotEmpty(s)) {
            for (String s1 : Lists.newArrayList(Splitter.on(",").split(s))) {
                longList.add(Long.valueOf(s1));
            }
        }
        return longList;

    }

    public static String convertListToString(List<String> stringList) {
        StringBuilder list = new StringBuilder();
        if (CollectionUtils.isNotEmpty(stringList)) {
            for (String s : stringList) {
                list.append(s);
                list.append(stringList.iterator().hasNext() ? ",": "");
            }
        }
        return list.toString();
    }


}
