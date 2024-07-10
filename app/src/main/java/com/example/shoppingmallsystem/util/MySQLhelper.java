package com.example.shoppingmallsystem.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * 创建SQLite数据库的工具类
 */
public class MySQLhelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "ShoppingMallInfo";
    public static final int VERSION = 1;

    public MySQLhelper(@Nullable Context context, @Nullable String DB_NAME, @Nullable SQLiteDatabase.CursorFactory factory, int VERSION) {
        super(context, DB_NAME, factory, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE userInfo(_id INTEGER PRIMARY KEY AUTOINCREMENT ,userName VERVHAR(20),password VERVHAR(20),nickName VERVHAR(20),phoneNumb VERVHAR(20),schoolName VERVHAR(20),apartmentNumb VERVHAR(20) , money REAL)");
        db.execSQL("CREATE TABLE storeInfo(_id INTEGER PRIMARY KEY autoincrement ,ID VERVHAR(20),picNumb VERVHAR(20),storeName VERVHAR(20),storeScore VERVHAR(20),storeSell VERVHAR(20) ,storeSign VERVHAR(20) ,storeIntro text )");
        db.execSQL("CREATE TABLE goodsInfo(_id INTEGER PRIMARY KEY autoincrement ,ID VERVHAR(20),goodsJson text)");
        db.execSQL("CREATE TABLE messagesInfo(_id INTEGER PRIMARY KEY autoincrement ,ID INTEGER,img_id VERVHAR(20),message text,userName VERVHAR(20),time VERVHAR(20))");
        db.execSQL("CREATE TABLE orderInfo(_id INTEGER PRIMARY KEY autoincrement ,userName VERVHAR(20),time VERVHAR(20),goodsJson text)");


        db.execSQL("INSERT INTO userInfo(userName,password,nickName,phoneNumb,schoolName,apartmentNumb,money) VALUES ('aaa','111','张三','15632586254','三里屯大学','N9号楼',0)");
        db.execSQL("INSERT INTO messagesInfo(ID,img_id,message,userName,time) VALUES (1,'1','我觉得店家1的商品就很不绰','aaa','2021.12.15 12:08')");


        db.execSQL("INSERT INTO storeInfo (ID,picNumb,storeName,storeScore,storeSell,storeSign,storeIntro)values ('0','0','米阳家具专营店','5.0','125','享折上折  屯居家好物','1.家用器具。《晋书·王述传》：“初， 述家贫，求试宛陵令，颇受赠遗，而修家具，为州司所检，有一千三百条。” 北魏 贾思勰 《齐民要术·槐柳楸梓梧柞》：“凡为家具者，前件木皆所宜种。” 宋 梅尧臣 《江邻几迁居》诗：“闻君迁新居，应比旧居好。复此假布囊，家具何草草。”《恨海》第六回：“﹝ 棣华 ﹞觅了一处房子，置备了一切动用家具。” 巴金 《灭亡》第二章：“这小小的房间底墙壁，以及房中的家具都不见了。”')");
        db.execSQL("INSERT INTO storeInfo (ID,picNumb,storeName,storeScore,storeSell,storeSign,storeIntro)values ('1','1','艺世界旗舰店','4.9','698','快来这里挑选家具日用吧','柳青《铜墙铁壁》第十八章：“一个背盒子枪和卡宾枪两件子家具的警卫员上来了。”　家用的器具，指木器，也包括炊事用具等。是人类日常生活和社会活动中使用的具有坐卧、凭倚、贮藏、间隔等功能的器具。通常由若干个零、部件按一定接合方式装配而成，已成为室内外装饰的重要组成部分。北魏贾思勰《齐民要术》五种槐柳楸梓梧柞：“凡为家具者，前件木皆所宜种。”可见，自古以来，中国家具一直以木材为主要用材，主要是木家具。\n" +
                "家具既是物质产品，又是艺术创作，这便是人们常说的家具二重特点。')");
        db.execSQL("INSERT INTO storeInfo (ID,picNumb,storeName,storeScore,storeSell,storeSign,storeIntro)values ('2','2','海尔官方旗舰店','4.7','253','来海尔，挑选智能家居','海尔集团 [8-9]  始终以用户体验为中心，踏准时代节拍，从资不抵债、濒临倒闭的集体小厂发展成引领物联网时代的生态型企业 [6]  ，连续两年作为全球唯一物联网生态品牌蝉联BrandZ最具价值全球品牌100强 [10-11]  。海尔拥有上市公司3家 [12-13]  ，在全球设立10+N开发式创新体系 [14]  、28个工业园、122个制造中心 [15]  ，108个营销中心和24万+销售网络 [13]  [16]  ，拥有海尔、卡萨帝、Leader、GE Appliances、Fisher&Paykel、AQUA、Candy等七大高端品牌和全球首个场景品牌“三翼鸟” [165]  ，构建了全球引领的工业互联网平台卡奥斯COSMOPlat [15]  、孵化了日日顺、盈康一生、海尔生物医疗 [17]  、海纳云 [18]  、海创汇 [15]  [19]  、海尔兄弟等众多生态品牌和新物种 [167]  。')");
        db.execSQL("INSERT INTO storeInfo (ID,picNumb,storeName,storeScore,storeSell,storeSign,storeIntro)values ('3','3','奥克斯康兴专卖店','4.6','544','奥克斯，享智能生活','奥克斯集团是中国500强企业、中国大企业集团竞争力前25强、中国信息化标杆企业、国家重点火炬高新技术企业，并为国家工程技术中心和国家级博士后工作站的常设单位，在宁波、上海、深圳、南昌建立了四大研究院；拥有“三星”和“奥克斯”两项跨行业的中国驰名商标和2个中国名牌产品。奥克斯空调位居行业第三，销售遍布中东、欧洲、亚太、非洲、美洲等100多个国家和地区 [25]  ，奥克斯集团设立“国家博士后工作站” [26]  。')");
        db.execSQL("INSERT INTO storeInfo (ID,picNumb,storeName,storeScore,storeSell,storeSign,storeIntro)values ('4','4','阿里健康大药房','4.9','123','阿里健康，保驾护航','借助阿里巴巴集团在电子商务、大数据和云计算领域的优势，为医药健康行业提供全面的互联网解决方案。2016年8月，阿里健康全资收购广州五千年医药连锁，并更名为阿里健康大药房。阿里健康大药房持有国家食品药品监督管理局颁发的《互联网药品交易许可证》，提供互联网药品交易服务。')");
        db.execSQL("INSERT INTO storeInfo (ID,picNumb,storeName,storeScore,storeSell,storeSign,storeIntro)values ('5','5','冰蓝国际数码','4.3','635','数码产品大卖场','我们通常说的“数码”指的是含有“数码技术”的数码产品，如数码相机、数码摄像机、数码学习机、数码随身听等等。随着科技的发展，计算机的出现、发展带动了一批以数字为记载标识的产品，取代了传统的胶片、录影带、录音带等，我们把这种产品统称为数码产品。 例如电视/通讯器材/移动或者便携的电子工具等, 在相当程度上都采用了数字化。')");
        db.execSQL("INSERT INTO storeInfo (ID,picNumb,storeName,storeScore,storeSell,storeSign,storeIntro)values ('6','6','南极人旗舰店','4.8','418','国货之光南极人','南极人，成立于1997年, 是中国最早成立的内衣企业之一，首创保暖内衣产品，开创了中国内衣行业发展的新道路。\n" +
                "历经22年的成长蜕变，南极人已经在内衣、母婴、服装、床品&布艺、厨品、鞋品、服饰配件、户外、家电等9大品类的55大类目产品线中取得突出的成绩，签约国民好媳妇海清，共同为国人带来 “全品类消费品王国”，努力打造让用户尖叫的产品，创造极致的用户体验。')");
        db.execSQL("INSERT INTO storeInfo (ID,picNumb,storeName,storeScore,storeSell,storeSign,storeIntro)values ('7','7','MAC魅可官方旗舰店','4.9','95','MAC魅可官方旗舰店','M∙A∙C彩妆创立于1984年，原创加拿大，现为美国雅诗兰黛旗下所有。第一支M∙A∙C彩妆的摄影需要，在镁光灯下诞生的。从第一批产品开始，M∙A∙C化妆品就以其丰富的色彩和独特的配方取得了成功，奠定了专业彩妆品牌的地位。M∙A∙C始终追求将时尚、快乐与幻想融合在一起，尊重不同种族、不同性别、不同年龄的人追求梦想和美丽的权利和自由，而M∙A∙C化妆品公司在艾滋病、反虐待及环保等社会事业的努力更显得难能可贵。Nicki Minaj、Lady Gaga等众多明星曾为其代言VIVA GLAM艾滋病爱心事业。')");
        db.execSQL("INSERT INTO storeInfo (ID,picNumb,storeName,storeScore,storeSell,storeSign,storeIntro)values ('8','8','李宁官方旗舰店','4.5','241','李宁官方旗舰店','李宁公司由著名体操运动员李宁先生创立。李宁公司成立于1990年，经过三十年的探索，已逐步成为代表中国的、国际领先的运动品牌公司。李宁公司采取多品牌业务发展策略，除自有核心李宁品牌（LI-NING），还拥有乐途品牌（LOTTO）、艾高品牌（AIGLE）、心动品牌（Z-DO）。此外，李宁公司控股上海红双喜、全资收购凯胜体育。')");
        db.execSQL("INSERT INTO storeInfo (ID,picNumb,storeName,storeScore,storeSell,storeSign,storeIntro)values ('9','9','广州木木夕乐器店','5.0','2365','多种乐器直营','乐器，英文：musical instruments，泛指可以用各种方法奏出音色音律的器物。一般分为民族乐器与西洋乐器。\n" +
                "能够发出乐音，并能进行音乐艺术再创造的器具。人类通过演奏乐器，借以表达、交流思想感情。对乐器的界定，音乐界和乐器学界有不同看法。\n" +
                "音乐界认为,用于音乐的发声器具才是乐器；乐器学界则通常将许多非音乐领域中的发声器具，如古代战争中的鸣金击鼓、宗教祈祷诵经中敲打的法器、婚丧中的礼仪信号、商贩招揽的信号器等，也视为乐器，甚至将一些生产劳动用具和日常生活器皿，如：弓、锯、杵、缶、杯、碟、盅、碗等等，在进行演奏时，都冠以乐字，称其为乐弓、乐锯、乐杯、乐杵等。')");


        db.execSQL("INSERT INTO goodsInfo (ID,goodsJson)values(0,'{\"itemsLeft\":[{\"title\":\"衣柜\"},{\"title\":\"床\"},{\"title\":\"被子\"},{\"title\":\"桌子\"}],\"itemsRight\":[{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"衣柜1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"1666.50\",\"title\":\"衣柜\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"衣柜2\",\"number\":0,\"picNumb\":\"2\",\"price\":\"950.85\",\"title\":\"衣柜\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"衣柜3\",\"number\":0,\"picNumb\":\"8\",\"price\":\"2520.00\",\"title\":\"衣柜\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"衣柜4\",\"number\":0,\"picNumb\":\"8\",\"price\":\"1650.00\",\"title\":\"衣柜\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"衣柜5\",\"number\":0,\"picNumb\":\"8\",\"price\":\"2950.00\",\"title\":\"衣柜\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"床1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"356.80\",\"title\":\"床\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"床2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"956.88\",\"title\":\"床\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"床3\",\"number\":0,\"picNumb\":\"9\",\"price\":\"1850.88\",\"title\":\"床\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"被子1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"110.99\",\"title\":\"被子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"被子2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"850.99\",\"title\":\"被子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"被子3\",\"number\":0,\"picNumb\":\"1\",\"price\":\"160.00\",\"title\":\"被子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"被子4\",\"number\":0,\"picNumb\":\"2\",\"price\":\"60.90\",\"title\":\"被子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"被子5\",\"number\":0,\"picNumb\":\"5\",\"price\":\"350.50\",\"title\":\"被子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"桌子1\",\"number\":0,\"picNumb\":\"1\",\"price\":\"110.99\",\"title\":\"桌子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"桌子2\",\"number\":0,\"picNumb\":\"3\",\"price\":\"150.99\",\"title\":\"桌子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"桌子3\",\"number\":0,\"picNumb\":\"5\",\"price\":\"900.99\",\"title\":\"桌子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"桌子4\",\"number\":0,\"picNumb\":\"1\",\"price\":\"1900.99\",\"title\":\"桌子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"桌子5\",\"number\":0,\"picNumb\":\"2\",\"price\":\"5230.99\",\"title\":\"桌子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"桌子6\",\"number\":0,\"picNumb\":\"9\",\"price\":\"1520.99\",\"title\":\"桌子\"}]}\n')");


        db.execSQL("INSERT INTO goodsInfo (ID,goodsJson)values(1,'{\"itemsLeft\":[{\"title\":\"镜子\"},{\"title\":\"衣架\"},{\"title\":\"被子\"},{\"title\":\"桌子\"}],\"itemsRight\":[{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"镜子1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"16.50\",\"title\":\"镜子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"镜子2\",\"number\":0,\"picNumb\":\"2\",\"price\":\"95.85\",\"title\":\"镜子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"镜子3\",\"number\":0,\"picNumb\":\"8\",\"price\":\"25.00\",\"title\":\"镜子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"镜子4\",\"number\":0,\"picNumb\":\"8\",\"price\":\"16.00\",\"title\":\"镜子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"镜子5\",\"number\":0,\"picNumb\":\"8\",\"price\":\"29.00\",\"title\":\"镜子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"衣架1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"35.80\",\"title\":\"衣架\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"衣架2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"95.88\",\"title\":\"衣架\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"衣架3\",\"number\":0,\"picNumb\":\"9\",\"price\":\"18.88\",\"title\":\"衣架\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"被子1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"110.99\",\"title\":\"被子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"被子2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"850.99\",\"title\":\"被子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"被子3\",\"number\":0,\"picNumb\":\"1\",\"price\":\"160.00\",\"title\":\"被子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"被子4\",\"number\":0,\"picNumb\":\"2\",\"price\":\"60.90\",\"title\":\"被子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"被子5\",\"number\":0,\"picNumb\":\"5\",\"price\":\"350.50\",\"title\":\"被子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"桌子1\",\"number\":0,\"picNumb\":\"1\",\"price\":\"110.99\",\"title\":\"桌子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"桌子2\",\"number\":0,\"picNumb\":\"3\",\"price\":\"150.99\",\"title\":\"桌子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"桌子3\",\"number\":0,\"picNumb\":\"5\",\"price\":\"900.99\",\"title\":\"桌子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"桌子4\",\"number\":0,\"picNumb\":\"1\",\"price\":\"1900.99\",\"title\":\"桌子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"桌子5\",\"number\":0,\"picNumb\":\"2\",\"price\":\"5230.99\",\"title\":\"桌子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"桌子6\",\"number\":0,\"picNumb\":\"9\",\"price\":\"1520.99\",\"title\":\"桌子\"}]}\n')");
        db.execSQL("INSERT INTO goodsInfo (ID,goodsJson)values(2,'{\"itemsLeft\":[{\"title\":\"冰箱\"},{\"title\":\"空调\"},{\"title\":\"洗衣机\"},{\"title\":\"太阳能\"}],\"itemsRight\":[{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"冰箱1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"1600.50\",\"title\":\"冰箱\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"冰箱2\",\"number\":0,\"picNumb\":\"2\",\"price\":\"9500.85\",\"title\":\"冰箱\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"冰箱3\",\"number\":0,\"picNumb\":\"8\",\"price\":\"2500.00\",\"title\":\"冰箱\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"冰箱4\",\"number\":0,\"picNumb\":\"8\",\"price\":\"1600.00\",\"title\":\"冰箱\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"冰箱5\",\"number\":0,\"picNumb\":\"8\",\"price\":\"2900.00\",\"title\":\"冰箱\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"空调1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"3500.80\",\"title\":\"空调\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"空调2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"9500.88\",\"title\":\"空调\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"空调3\",\"number\":0,\"picNumb\":\"9\",\"price\":\"1800.88\",\"title\":\"空调\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"洗衣机1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"1100.99\",\"title\":\"洗衣机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"洗衣机2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"850.99\",\"title\":\"洗衣机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"洗衣机3\",\"number\":0,\"picNumb\":\"1\",\"price\":\"1600.00\",\"title\":\"洗衣机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"洗衣机4\",\"number\":0,\"picNumb\":\"2\",\"price\":\"6000.90\",\"title\":\"洗衣机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"洗衣机5\",\"number\":0,\"picNumb\":\"5\",\"price\":\"3500.50\",\"title\":\"洗衣机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"太阳能1\",\"number\":0,\"picNumb\":\"1\",\"price\":\"1100.99\",\"title\":\"太阳能\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"太阳能2\",\"number\":0,\"picNumb\":\"3\",\"price\":\"1500.99\",\"title\":\"太阳能\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"太阳能3\",\"number\":0,\"picNumb\":\"5\",\"price\":\"9000.99\",\"title\":\"太阳能\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"太阳能4\",\"number\":0,\"picNumb\":\"1\",\"price\":\"1900.99\",\"title\":\"太阳能\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"太阳能5\",\"number\":0,\"picNumb\":\"2\",\"price\":\"5230.99\",\"title\":\"太阳能\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"太阳能6\",\"number\":0,\"picNumb\":\"9\",\"price\":\"1520.99\",\"title\":\"太阳能\"}]}\n')");
        db.execSQL("INSERT INTO goodsInfo (ID,goodsJson)values(3,'{\"itemsLeft\":[{\"title\":\"冰箱\"},{\"title\":\"空调\"},{\"title\":\"洗衣机\"},{\"title\":\"太阳能\"}],\"itemsRight\":[{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"冰箱1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"1600.50\",\"title\":\"冰箱\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"冰箱2\",\"number\":0,\"picNumb\":\"2\",\"price\":\"9500.85\",\"title\":\"冰箱\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"冰箱3\",\"number\":0,\"picNumb\":\"8\",\"price\":\"2500.00\",\"title\":\"冰箱\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"冰箱4\",\"number\":0,\"picNumb\":\"8\",\"price\":\"1600.00\",\"title\":\"冰箱\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"冰箱5\",\"number\":0,\"picNumb\":\"8\",\"price\":\"2900.00\",\"title\":\"冰箱\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"空调1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"3500.80\",\"title\":\"空调\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"空调2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"9500.88\",\"title\":\"空调\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"空调3\",\"number\":0,\"picNumb\":\"9\",\"price\":\"1800.88\",\"title\":\"空调\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"洗衣机1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"1100.99\",\"title\":\"洗衣机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"洗衣机2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"850.99\",\"title\":\"洗衣机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"洗衣机3\",\"number\":0,\"picNumb\":\"1\",\"price\":\"1600.00\",\"title\":\"洗衣机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"洗衣机4\",\"number\":0,\"picNumb\":\"2\",\"price\":\"6000.90\",\"title\":\"洗衣机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"洗衣机5\",\"number\":0,\"picNumb\":\"5\",\"price\":\"3500.50\",\"title\":\"洗衣机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"太阳能1\",\"number\":0,\"picNumb\":\"1\",\"price\":\"1100.99\",\"title\":\"太阳能\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"太阳能2\",\"number\":0,\"picNumb\":\"3\",\"price\":\"1500.99\",\"title\":\"太阳能\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"太阳能3\",\"number\":0,\"picNumb\":\"5\",\"price\":\"9000.99\",\"title\":\"太阳能\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"太阳能4\",\"number\":0,\"picNumb\":\"1\",\"price\":\"1900.99\",\"title\":\"太阳能\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"太阳能5\",\"number\":0,\"picNumb\":\"2\",\"price\":\"5230.99\",\"title\":\"太阳能\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"太阳能6\",\"number\":0,\"picNumb\":\"9\",\"price\":\"1520.99\",\"title\":\"太阳能\"}]}\n')");
        db.execSQL("INSERT INTO goodsInfo (ID,goodsJson)values(4,'{\"itemsLeft\":[{\"title\":\"日常药品\"},{\"title\":\"心血管药品\"},{\"title\":\"肠胃药\"},{\"title\":\"皮肤药\"}],\"itemsRight\":[{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"日常药品1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"16.50\",\"title\":\"日常药品\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"日常药品2\",\"number\":0,\"picNumb\":\"2\",\"price\":\"95.85\",\"title\":\"日常药品\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"日常药品3\",\"number\":0,\"picNumb\":\"8\",\"price\":\"25.00\",\"title\":\"日常药品\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"日常药品4\",\"number\":0,\"picNumb\":\"8\",\"price\":\"16.00\",\"title\":\"日常药品\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"日常药品5\",\"number\":0,\"picNumb\":\"8\",\"price\":\"29.00\",\"title\":\"日常药品\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"心血管药品1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"35.80\",\"title\":\"心血管药品\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"心血管药品2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"95.88\",\"title\":\"心血管药品\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"心血管药品3\",\"number\":0,\"picNumb\":\"9\",\"price\":\"69.88\",\"title\":\"心血管药品\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"心血管药品4\",\"number\":0,\"picNumb\":\"1\",\"price\":\"18.88\",\"title\":\"心血管药品\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"肠胃药1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"110.99\",\"title\":\"肠胃药\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"肠胃药2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"85.99\",\"title\":\"肠胃药\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"肠胃药3\",\"number\":0,\"picNumb\":\"1\",\"price\":\"16.00\",\"title\":\"肠胃药\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"肠胃药4\",\"number\":0,\"picNumb\":\"2\",\"price\":\"60.90\",\"title\":\"肠胃药\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"肠胃药5\",\"number\":0,\"picNumb\":\"5\",\"price\":\"35.50\",\"title\":\"肠胃药\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"皮肤药1\",\"number\":0,\"picNumb\":\"1\",\"price\":\"11.99\",\"title\":\"皮肤药\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"皮肤药2\",\"number\":0,\"picNumb\":\"3\",\"price\":\"15.99\",\"title\":\"皮肤药\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"皮肤药3\",\"number\":0,\"picNumb\":\"5\",\"price\":\"90.99\",\"title\":\"皮肤药\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"皮肤药4\",\"number\":0,\"picNumb\":\"1\",\"price\":\"19.99\",\"title\":\"皮肤药\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"皮肤药5\",\"number\":0,\"picNumb\":\"2\",\"price\":\"52.99\",\"title\":\"皮肤药\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"皮肤药6\",\"number\":0,\"picNumb\":\"9\",\"price\":\"15.99\",\"title\":\"皮肤药\"}]}\n')");
        db.execSQL("INSERT INTO goodsInfo (ID,goodsJson)values(5,'{\"itemsLeft\":[{\"title\":\"照相机\"},{\"title\":\"耳机\"},{\"title\":\"电视\"},{\"title\":\"无人机\"}],\"itemsRight\":[{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"照相机1\",\"number\":0,\"picNumb\":\"1\",\"price\":\"1600.50\",\"title\":\"照相机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"照相机2\",\"number\":0,\"picNumb\":\"2\",\"price\":\"9500.85\",\"title\":\"照相机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"照相机3\",\"number\":0,\"picNumb\":\"8\",\"price\":\"2500.00\",\"title\":\"照相机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"照相机4\",\"number\":0,\"picNumb\":\"9\",\"price\":\"1600.00\",\"title\":\"照相机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"照相机5\",\"number\":0,\"picNumb\":\"8\",\"price\":\"2900.00\",\"title\":\"照相机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"耳机1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"350.80\",\"title\":\"耳机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"耳机2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"950.88\",\"title\":\"耳机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"耳机3\",\"number\":0,\"picNumb\":\"9\",\"price\":\"690.88\",\"title\":\"耳机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"耳机4\",\"number\":0,\"picNumb\":\"1\",\"price\":\"180.88\",\"title\":\"耳机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"电视1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"1100.99\",\"title\":\"电视\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"电视2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"8500.99\",\"title\":\"电视\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"电视3\",\"number\":0,\"picNumb\":\"1\",\"price\":\"1600.00\",\"title\":\"电视\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"电视4\",\"number\":0,\"picNumb\":\"2\",\"price\":\"6000.90\",\"title\":\"电视\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"电视5\",\"number\":0,\"picNumb\":\"5\",\"price\":\"3500.50\",\"title\":\"电视\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"无人机1\",\"number\":0,\"picNumb\":\"9\",\"price\":\"1100.99\",\"title\":\"无人机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"无人机2\",\"number\":0,\"picNumb\":\"1\",\"price\":\"1500.99\",\"title\":\"无人机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"无人机3\",\"number\":0,\"picNumb\":\"2\",\"price\":\"9000.99\",\"title\":\"无人机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"无人机4\",\"number\":0,\"picNumb\":\"3\",\"price\":\"1900.99\",\"title\":\"无人机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"无人机5\",\"number\":0,\"picNumb\":\"9\",\"price\":\"5200.99\",\"title\":\"无人机\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"无人机6\",\"number\":0,\"picNumb\":\"5\",\"price\":\"1500.99\",\"title\":\"无人机\"}]}\n')");
        db.execSQL("INSERT INTO goodsInfo (ID,goodsJson)values(6,'{\"itemsLeft\":[{\"title\":\"内衣\"},{\"title\":\"保暖衣\"},{\"title\":\"冲锋衣\"},{\"title\":\"登山靴\"},{\"title\":\"袜子\"}],\"itemsRight\":[{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"内衣1\",\"number\":0,\"picNumb\":\"1\",\"price\":\"16.50\",\"title\":\"内衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"内衣2\",\"number\":0,\"picNumb\":\"2\",\"price\":\"95.85\",\"title\":\"内衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"内衣3\",\"number\":0,\"picNumb\":\"8\",\"price\":\"25.00\",\"title\":\"内衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"内衣4\",\"number\":0,\"picNumb\":\"9\",\"price\":\"16.00\",\"title\":\"内衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"内衣5\",\"number\":0,\"picNumb\":\"8\",\"price\":\"29.00\",\"title\":\"内衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"保暖衣1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"35.80\",\"title\":\"保暖衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"保暖衣2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"95.88\",\"title\":\"保暖衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"保暖衣3\",\"number\":0,\"picNumb\":\"9\",\"price\":\"69.88\",\"title\":\"保暖衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"保暖衣4\",\"number\":0,\"picNumb\":\"1\",\"price\":\"95.88\",\"title\":\"保暖衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"冲锋衣1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"110.99\",\"title\":\"冲锋衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"冲锋衣2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"850.99\",\"title\":\"冲锋衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"冲锋衣3\",\"number\":0,\"picNumb\":\"1\",\"price\":\"160.00\",\"title\":\"冲锋衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"冲锋衣4\",\"number\":0,\"picNumb\":\"2\",\"price\":\"600.90\",\"title\":\"冲锋衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"冲锋衣5\",\"number\":0,\"picNumb\":\"5\",\"price\":\"350.50\",\"title\":\"冲锋衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"登山靴1\",\"number\":0,\"picNumb\":\"9\",\"price\":\"110.99\",\"title\":\"登山靴\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"登山靴2\",\"number\":0,\"picNumb\":\"1\",\"price\":\"150.99\",\"title\":\"登山靴\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"登山靴3\",\"number\":0,\"picNumb\":\"2\",\"price\":\"900.99\",\"title\":\"登山靴\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"登山靴4\",\"number\":0,\"picNumb\":\"3\",\"price\":\"190.99\",\"title\":\"登山靴\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"登山靴5\",\"number\":0,\"picNumb\":\"9\",\"price\":\"520.99\",\"title\":\"登山靴\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"登山靴6\",\"number\":0,\"picNumb\":\"5\",\"price\":\"150.99\",\"title\":\"登山靴\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"袜子1\",\"number\":0,\"picNumb\":\"2\",\"price\":\"15.99\",\"title\":\"袜子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"袜子2\",\"number\":0,\"picNumb\":\"9\",\"price\":\"15.99\",\"title\":\"袜子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"袜子3\",\"number\":0,\"picNumb\":\"5\",\"price\":\"15.99\",\"title\":\"袜子\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"袜子4\",\"number\":0,\"picNumb\":\"1\",\"price\":\"15.99\",\"title\":\"袜子\"}]}\n')");
        db.execSQL("INSERT INTO goodsInfo (ID,goodsJson)values(7,'{\"itemsLeft\":[{\"title\":\"口红\"},{\"title\":\"粉底\"},{\"title\":\"香水\"},{\"title\":\"遮瑕\"}],\"itemsRight\":[{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"口红1\",\"number\":0,\"picNumb\":\"1\",\"price\":\"160.50\",\"title\":\"口红\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"口红2\",\"number\":0,\"picNumb\":\"2\",\"price\":\"950.85\",\"title\":\"口红\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"口红3\",\"number\":0,\"picNumb\":\"8\",\"price\":\"250.00\",\"title\":\"口红\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"口红4\",\"number\":0,\"picNumb\":\"9\",\"price\":\"160.00\",\"title\":\"口红\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"口红5\",\"number\":0,\"picNumb\":\"8\",\"price\":\"290.00\",\"title\":\"口红\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"粉底1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"35.80\",\"title\":\"粉底\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"粉底2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"95.88\",\"title\":\"粉底\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"粉底3\",\"number\":0,\"picNumb\":\"9\",\"price\":\"69.88\",\"title\":\"粉底\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"粉底4\",\"number\":0,\"picNumb\":\"1\",\"price\":\"95.88\",\"title\":\"粉底\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"香水1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"110.99\",\"title\":\"香水\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"香水2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"850.99\",\"title\":\"香水\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"香水3\",\"number\":0,\"picNumb\":\"1\",\"price\":\"160.00\",\"title\":\"香水\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"香水4\",\"number\":0,\"picNumb\":\"2\",\"price\":\"600.90\",\"title\":\"香水\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"香水5\",\"number\":0,\"picNumb\":\"5\",\"price\":\"350.50\",\"title\":\"香水\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"遮瑕1\",\"number\":0,\"picNumb\":\"9\",\"price\":\"110.99\",\"title\":\"遮瑕\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"遮瑕2\",\"number\":0,\"picNumb\":\"1\",\"price\":\"150.99\",\"title\":\"遮瑕\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"遮瑕3\",\"number\":0,\"picNumb\":\"2\",\"price\":\"90.99\",\"title\":\"遮瑕\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"遮瑕4\",\"number\":0,\"picNumb\":\"3\",\"price\":\"190.99\",\"title\":\"遮瑕\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"遮瑕5\",\"number\":0,\"picNumb\":\"9\",\"price\":\"52.99\",\"title\":\"遮瑕\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"遮瑕6\",\"number\":0,\"picNumb\":\"5\",\"price\":\"150.99\",\"title\":\"遮瑕\"}]}\n')");
        db.execSQL("INSERT INTO goodsInfo (ID,goodsJson)values(8,'{\"itemsLeft\":[{\"title\":\"速干衣\"},{\"title\":\"跑步鞋\"},{\"title\":\"篮球鞋\"},{\"title\":\"半袖\"},{\"title\":\"长裤\"}],\"itemsRight\":[{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"速干衣1\",\"number\":0,\"picNumb\":\"1\",\"price\":\"160.50\",\"title\":\"速干衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"速干衣2\",\"number\":0,\"picNumb\":\"2\",\"price\":\"95.85\",\"title\":\"速干衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"速干衣3\",\"number\":0,\"picNumb\":\"8\",\"price\":\"190.00\",\"title\":\"速干衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"速干衣4\",\"number\":0,\"picNumb\":\"9\",\"price\":\"120.00\",\"title\":\"速干衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"速干衣5\",\"number\":0,\"picNumb\":\"8\",\"price\":\"230.00\",\"title\":\"速干衣\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"跑步鞋1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"350.80\",\"title\":\"跑步鞋\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"跑步鞋2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"950.88\",\"title\":\"跑步鞋\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"跑步鞋3\",\"number\":0,\"picNumb\":\"9\",\"price\":\"690.88\",\"title\":\"跑步鞋\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"跑步鞋4\",\"number\":0,\"picNumb\":\"1\",\"price\":\"950.88\",\"title\":\"跑步鞋\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"篮球鞋1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"110.99\",\"title\":\"篮球鞋\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"篮球鞋2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"850.99\",\"title\":\"篮球鞋\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"篮球鞋3\",\"number\":0,\"picNumb\":\"1\",\"price\":\"160.00\",\"title\":\"篮球鞋\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"篮球鞋4\",\"number\":0,\"picNumb\":\"2\",\"price\":\"600.90\",\"title\":\"篮球鞋\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"篮球鞋5\",\"number\":0,\"picNumb\":\"5\",\"price\":\"350.50\",\"title\":\"篮球鞋\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"半袖1\",\"number\":0,\"picNumb\":\"9\",\"price\":\"110.99\",\"title\":\"半袖\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"半袖2\",\"number\":0,\"picNumb\":\"1\",\"price\":\"150.99\",\"title\":\"半袖\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"半袖3\",\"number\":0,\"picNumb\":\"2\",\"price\":\"90.99\",\"title\":\"半袖\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"半袖4\",\"number\":0,\"picNumb\":\"3\",\"price\":\"190.99\",\"title\":\"半袖\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"半袖5\",\"number\":0,\"picNumb\":\"9\",\"price\":\"52.99\",\"title\":\"半袖\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"半袖6\",\"number\":0,\"picNumb\":\"5\",\"price\":\"150.99\",\"title\":\"半袖\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"长裤1\",\"number\":0,\"picNumb\":\"2\",\"price\":\"150.99\",\"title\":\"长裤\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"长裤2\",\"number\":0,\"picNumb\":\"9\",\"price\":\"150.99\",\"title\":\"长裤\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"长裤3\",\"number\":0,\"picNumb\":\"5\",\"price\":\"150.99\",\"title\":\"长裤\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"长裤4\",\"number\":0,\"picNumb\":\"1\",\"price\":\"150.99\",\"title\":\"长裤\"}]}\n')");
        db.execSQL("INSERT INTO goodsInfo (ID,goodsJson)values(9,'{\"itemsLeft\":[{\"title\":\"吉他\"},{\"title\":\"尤克里里\"},{\"title\":\"钢琴\"},{\"title\":\"长笛\"},{\"title\":\"架子鼓\"}],\"itemsRight\":[{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"吉他1\",\"number\":0,\"picNumb\":\"1\",\"price\":\"1600.50\",\"title\":\"吉他\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"吉他2\",\"number\":0,\"picNumb\":\"2\",\"price\":\"950.85\",\"title\":\"吉他\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"吉他3\",\"number\":0,\"picNumb\":\"8\",\"price\":\"1900.00\",\"title\":\"吉他\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"吉他4\",\"number\":0,\"picNumb\":\"9\",\"price\":\"1200.00\",\"title\":\"吉他\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"吉他5\",\"number\":0,\"picNumb\":\"8\",\"price\":\"2300.00\",\"title\":\"吉他\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"尤克里里1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"350.80\",\"title\":\"尤克里里\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"尤克里里2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"950.88\",\"title\":\"尤克里里\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"尤克里里3\",\"number\":0,\"picNumb\":\"9\",\"price\":\"690.88\",\"title\":\"尤克里里\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"尤克里里4\",\"number\":0,\"picNumb\":\"1\",\"price\":\"950.88\",\"title\":\"尤克里里\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"钢琴1\",\"number\":0,\"picNumb\":\"6\",\"price\":\"11000.99\",\"title\":\"钢琴\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"钢琴2\",\"number\":0,\"picNumb\":\"5\",\"price\":\"85000.99\",\"title\":\"钢琴\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"钢琴3\",\"number\":0,\"picNumb\":\"1\",\"price\":\"16000.00\",\"title\":\"钢琴\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"钢琴4\",\"number\":0,\"picNumb\":\"2\",\"price\":\"60000.90\",\"title\":\"钢琴\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"钢琴5\",\"number\":0,\"picNumb\":\"5\",\"price\":\"35000.50\",\"title\":\"钢琴\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"长笛1\",\"number\":0,\"picNumb\":\"9\",\"price\":\"110.99\",\"title\":\"长笛\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"长笛2\",\"number\":0,\"picNumb\":\"1\",\"price\":\"150.99\",\"title\":\"长笛\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"长笛3\",\"number\":0,\"picNumb\":\"2\",\"price\":\"90.99\",\"title\":\"长笛\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"长笛4\",\"number\":0,\"picNumb\":\"3\",\"price\":\"190.99\",\"title\":\"长笛\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"长笛5\",\"number\":0,\"picNumb\":\"9\",\"price\":\"52.99\",\"title\":\"长笛\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"长笛6\",\"number\":0,\"picNumb\":\"5\",\"price\":\"150.99\",\"title\":\"长笛\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"架子鼓1\",\"number\":0,\"picNumb\":\"2\",\"price\":\"1500.99\",\"title\":\"架子鼓\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"架子鼓2\",\"number\":0,\"picNumb\":\"9\",\"price\":\"1500.99\",\"title\":\"架子鼓\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"架子鼓3\",\"number\":0,\"picNumb\":\"5\",\"price\":\"1500.99\",\"title\":\"架子鼓\"},{\"content\":\"我是商品标题展示数据。。。\",\"name\":\"架子鼓4\",\"number\":0,\"picNumb\":\"1\",\"price\":\"1500.99\",\"title\":\"架子鼓\"}]}\n')");


        }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
