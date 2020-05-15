package cn.com.zv2.test.lambda;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lb
 * @description
 * @date 2020/5/15
 */
public class TaowaTest {
    public static void main(String[] args) {
        List<Purchaser> list = Lists.newArrayList();
        Purchaser purchaser = new Purchaser();
        purchaser.setId("a09232");
        purchaser.setName("zhangshan");
        purchaser.setGender("F");
        purchaser.setAvatar("/upload/avatar/a09232.webp");
        Purchaser purchaserOne = new Purchaser();
        purchaserOne.setId(null);
        purchaserOne.setName("lisisi");
        purchaserOne.setProfile("go, friend.jpg");
        Purchaser purchaserTwo = new Purchaser();
        purchaserTwo.setId("Z90323");
        purchaserTwo.setName("madongmei");
        purchaserTwo.setGender("F");
        purchaserTwo.setProfile("what mei, what dong");
        list.add(purchaser);
        list.add(purchaserOne);
        list.add(purchaserTwo);
        list.stream().filter(i -> StringUtils.isNotEmpty(i.getId()))
                .map(Purchaser::getId).collect(Collectors.toList());

        List<PurchaserWithGoods> currList = fetchMore();
        currList.forEach(i -> {
            list.parallelStream().filter(j -> StringUtils.isNotEmpty(j.getId()))
                    .filter(j -> (j.getId() == i.getId())).forEach(j -> {
                j.setName(i.getName());
                j.setGender(i.getGender());
                j.setAvatar(i.getAvatar());
                j.setProfile(i.getProfile());
            });
        });

        list.forEach(System.out::println);
    }

    private static List<PurchaserWithGoods> fetchMore() {
        List<PurchaserWithGoods> list = Lists.newArrayList();
        PurchaserWithGoods purchaser = new PurchaserWithGoods();
        purchaser.setId("a09232");
        purchaser.setName("Lily");
        purchaser.setGender("Unknown");
        purchaser.setAvatar("/upload/avatar/a09232.webp");
        purchaser.setProfile("more money, more purchase");

        PurchaserWithGoods purchaserOne = new PurchaserWithGoods();
        purchaserOne.setId("902323");
        purchaserOne.setName("beauty");
        purchaserOne.setProfile("hei, girl");

        PurchaserWithGoods purchaserTwo = new PurchaserWithGoods();
        purchaserTwo.setId("Z90323");
        purchaserTwo.setName("madongmei");
        purchaserTwo.setGender("F");
        purchaserTwo.setAvatar("/upload/avatar/null");
        purchaserTwo.setProfile("i'm madongmei.shit");

        list.add(purchaser);
        list.add(purchaserOne);
        list.add(purchaserTwo);
        return list;
    }
}
