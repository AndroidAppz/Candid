package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* compiled from: DynamicLayoutInflator */
public class jg {
    public static final String[] a = new String[]{"TopLeft", "TopRight", "BottomRight", "BottomLeft"};
    public static int b = 1234567;
    public static Map<String, jg$c> c;
    private static final String d = null;
    private static jg$b e = null;

    public static void a(View root, Object delegate) {
        jg$a info;
        if (root.getTag() == null || !(root.getTag() instanceof jg$a)) {
            info = new jg$a();
            root.setTag(info);
        } else {
            info = (jg$a) root.getTag();
        }
        info.b = delegate;
    }

    public static View a(Context context, String xml, ViewGroup parent) {
        return jg.a(context, new ByteArrayInputStream(xml.getBytes()), parent);
    }

    public static View a(Context context, InputStream inputStream, ViewGroup parent) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            View a = jg.a(context, dbf.newDocumentBuilder().parse(inputStream).getDocumentElement(), parent);
            inputStream.close();
            return a;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParserConfigurationException e2) {
            e2.printStackTrace();
            return null;
        } catch (SAXException e3) {
            e3.printStackTrace();
            return null;
        } catch (Throwable th) {
            inputStream.close();
        }
    }

    public static View a(Context context, Node node, ViewGroup parent) {
        View mainView = jg.a(context, node.getNodeName());
        if (parent != null) {
            parent.addView(mainView);
        }
        jg.a(mainView, jg.a(node), parent);
        if ((mainView instanceof ViewGroup) && node.hasChildNodes()) {
            jg.b(context, node, (ViewGroup) mainView);
        }
        return mainView;
    }

    private static void b(Context context, Node node, ViewGroup mainView) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == (short) 1) {
                jg.a(context, currentNode, mainView);
            }
        }
    }

    private static View a(Context context, String name) {
        try {
            if (!name.contains(".")) {
                name = "android.widget." + name;
            }
            return (View) Class.forName(name).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        } catch (InstantiationException e4) {
            e4.printStackTrace();
            return null;
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private static HashMap<String, String> a(Node currentNode) {
        NamedNodeMap attributeMap = currentNode.getAttributes();
        int attributeCount = attributeMap.getLength();
        HashMap<String, String> attributes = new HashMap(attributeCount);
        for (int j = 0; j < attributeCount; j++) {
            Node attr = attributeMap.item(j);
            String nodeName = attr.getNodeName();
            if (nodeName.startsWith("android:")) {
                nodeName = nodeName.substring(8);
            }
            attributes.put(nodeName, attr.getNodeValue());
        }
        return attributes;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    private static void a(android.view.View r40, java.util.Map<java.lang.String, java.lang.String> r41, android.view.ViewGroup r42) {
        /*
        r36 = c;
        if (r36 != 0) goto L_0x0007;
    L_0x0004:
        defpackage.jg.a();
    L_0x0007:
        r20 = r40.getLayoutParams();
        r24 = 0;
        r25 = 0;
        r26 = 0;
        r23 = 0;
        r29 = 0;
        r30 = 0;
        r31 = 0;
        r28 = 0;
        r16 = 0;
        r15 = 0;
        r36 = r41.entrySet();
        r38 = r36.iterator();
    L_0x0026:
        r36 = r38.hasNext();
        if (r36 == 0) goto L_0x0595;
    L_0x002c:
        r13 = r38.next();
        r13 = (java.util.Map.Entry) r13;
        r6 = r13.getKey();
        r6 = (java.lang.String) r6;
        r36 = c;
        r0 = r36;
        r36 = r0.containsKey(r6);
        if (r36 == 0) goto L_0x0060;
    L_0x0042:
        r36 = c;
        r0 = r36;
        r36 = r0.get(r6);
        r36 = (defpackage.jg$c) r36;
        r37 = r13.getValue();
        r37 = (java.lang.String) r37;
        r0 = r36;
        r1 = r40;
        r2 = r37;
        r3 = r42;
        r4 = r41;
        r0.a(r1, r2, r3, r4);
        goto L_0x0026;
    L_0x0060:
        r36 = "cornerRadius";
        r0 = r36;
        r36 = r6.startsWith(r0);
        if (r36 == 0) goto L_0x007a;
    L_0x006a:
        r16 = 1;
        r36 = "cornerRadius";
        r0 = r36;
        r36 = r6.equals(r0);
        if (r36 != 0) goto L_0x0078;
    L_0x0076:
        r15 = 1;
    L_0x0077:
        goto L_0x0026;
    L_0x0078:
        r15 = 0;
        goto L_0x0077;
    L_0x007a:
        r21 = -999; // 0xfffffffffffffc19 float:NaN double:NaN;
        r22 = 0;
        r36 = -1;
        r37 = r6.hashCode();
        switch(r37) {
            case -2116816901: goto L_0x0150;
            case -2082866616: goto L_0x0126;
            case -2081856804: goto L_0x0118;
            case -2062351247: goto L_0x00d5;
            case -1843564606: goto L_0x01dc;
            case -1842318840: goto L_0x01ce;
            case -1768054459: goto L_0x01a4;
            case -1725075762: goto L_0x01f8;
            case -1501175880: goto L_0x0276;
            case -1221029593: goto L_0x00e2;
            case -1187019509: goto L_0x0196;
            case -1187005051: goto L_0x015e;
            case -954382862: goto L_0x023e;
            case -806339567: goto L_0x0268;
            case -603137010: goto L_0x0134;
            case -372205757: goto L_0x0142;
            case -336747103: goto L_0x01c0;
            case 3355: goto L_0x00bb;
            case 58626012: goto L_0x00ef;
            case 90130308: goto L_0x0284;
            case 113126854: goto L_0x00c8;
            case 148567150: goto L_0x025a;
            case 198345827: goto L_0x0222;
            case 202355100: goto L_0x02a0;
            case 478654218: goto L_0x0230;
            case 488063277: goto L_0x010a;
            case 524348576: goto L_0x0206;
            case 543320065: goto L_0x01ea;
            case 543334523: goto L_0x01b2;
            case 713848971: goto L_0x0292;
            case 1295141433: goto L_0x00fc;
            case 1747415628: goto L_0x0188;
            case 1748661394: goto L_0x017a;
            case 1857300951: goto L_0x016c;
            case 1959039865: goto L_0x024c;
            case 2044548953: goto L_0x0214;
            default: goto L_0x0087;
        };
    L_0x0087:
        switch(r36) {
            case 0: goto L_0x02ae;
            case 1: goto L_0x02e0;
            case 2: goto L_0x02e0;
            case 3: goto L_0x0359;
            case 4: goto L_0x0359;
            case 5: goto L_0x03d2;
            case 6: goto L_0x0412;
            case 7: goto L_0x0432;
            case 8: goto L_0x0438;
            case 9: goto L_0x043e;
            case 10: goto L_0x0444;
            case 11: goto L_0x044a;
            case 12: goto L_0x0450;
            case 13: goto L_0x0456;
            case 14: goto L_0x0456;
            case 15: goto L_0x045c;
            case 16: goto L_0x045c;
            case 17: goto L_0x0462;
            case 18: goto L_0x0466;
            case 19: goto L_0x046a;
            case 20: goto L_0x046a;
            case 21: goto L_0x046e;
            case 22: goto L_0x046e;
            case 23: goto L_0x0472;
            case 24: goto L_0x0476;
            case 25: goto L_0x047a;
            case 26: goto L_0x047e;
            case 27: goto L_0x0498;
            case 28: goto L_0x04b6;
            case 29: goto L_0x04d4;
            case 30: goto L_0x04f2;
            case 31: goto L_0x0510;
            case 32: goto L_0x052a;
            case 33: goto L_0x053e;
            case 34: goto L_0x0552;
            case 35: goto L_0x0566;
            default: goto L_0x008a;
        };
    L_0x008a:
        r36 = -999; // 0xfffffffffffffc19 float:NaN double:NaN;
        r0 = r21;
        r1 = r36;
        if (r0 == r1) goto L_0x0026;
    L_0x0092:
        r0 = r42;
        r0 = r0 instanceof android.widget.RelativeLayout;
        r36 = r0;
        if (r36 == 0) goto L_0x0026;
    L_0x009a:
        if (r22 == 0) goto L_0x057a;
    L_0x009c:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r36 = defpackage.jg.b(r36);
        r0 = r42;
        r1 = r36;
        r5 = defpackage.jg.a(r0, r1);
        r36 = r20;
        r36 = (android.widget.RelativeLayout.LayoutParams) r36;
        r0 = r36;
        r1 = r21;
        r0.addRule(r1, r5);
        goto L_0x0026;
    L_0x00bb:
        r37 = "id";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x00c5:
        r36 = 0;
        goto L_0x0087;
    L_0x00c8:
        r37 = "width";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x00d2:
        r36 = 1;
        goto L_0x0087;
    L_0x00d5:
        r37 = "layout_width";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x00df:
        r36 = 2;
        goto L_0x0087;
    L_0x00e2:
        r37 = "height";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x00ec:
        r36 = 3;
        goto L_0x0087;
    L_0x00ef:
        r37 = "layout_height";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x00f9:
        r36 = 4;
        goto L_0x0087;
    L_0x00fc:
        r37 = "layout_gravity";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x0106:
        r36 = 5;
        goto L_0x0087;
    L_0x010a:
        r37 = "layout_weight";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x0114:
        r36 = 6;
        goto L_0x0087;
    L_0x0118:
        r37 = "layout_below";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x0122:
        r36 = 7;
        goto L_0x0087;
    L_0x0126:
        r37 = "layout_above";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x0130:
        r36 = 8;
        goto L_0x0087;
    L_0x0134:
        r37 = "layout_toLeftOf";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x013e:
        r36 = 9;
        goto L_0x0087;
    L_0x0142:
        r37 = "layout_toRightOf";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x014c:
        r36 = 10;
        goto L_0x0087;
    L_0x0150:
        r37 = "layout_alignBottom";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x015a:
        r36 = 11;
        goto L_0x0087;
    L_0x015e:
        r37 = "layout_alignTop";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x0168:
        r36 = 12;
        goto L_0x0087;
    L_0x016c:
        r37 = "layout_alignLeft";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x0176:
        r36 = 13;
        goto L_0x0087;
    L_0x017a:
        r37 = "layout_alignStart";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x0184:
        r36 = 14;
        goto L_0x0087;
    L_0x0188:
        r37 = "layout_alignRight";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x0192:
        r36 = 15;
        goto L_0x0087;
    L_0x0196:
        r37 = "layout_alignEnd";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x01a0:
        r36 = 16;
        goto L_0x0087;
    L_0x01a4:
        r37 = "layout_alignParentBottom";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x01ae:
        r36 = 17;
        goto L_0x0087;
    L_0x01b2:
        r37 = "layout_alignParentTop";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x01bc:
        r36 = 18;
        goto L_0x0087;
    L_0x01c0:
        r37 = "layout_alignParentLeft";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x01ca:
        r36 = 19;
        goto L_0x0087;
    L_0x01ce:
        r37 = "layout_alignParentStart";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x01d8:
        r36 = 20;
        goto L_0x0087;
    L_0x01dc:
        r37 = "layout_alignParentRight";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x01e6:
        r36 = 21;
        goto L_0x0087;
    L_0x01ea:
        r37 = "layout_alignParentEnd";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x01f4:
        r36 = 22;
        goto L_0x0087;
    L_0x01f8:
        r37 = "layout_centerHorizontal";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x0202:
        r36 = 23;
        goto L_0x0087;
    L_0x0206:
        r37 = "layout_centerVertical";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x0210:
        r36 = 24;
        goto L_0x0087;
    L_0x0214:
        r37 = "layout_centerInParent";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x021e:
        r36 = 25;
        goto L_0x0087;
    L_0x0222:
        r37 = "layout_margin";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x022c:
        r36 = 26;
        goto L_0x0087;
    L_0x0230:
        r37 = "layout_marginLeft";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x023a:
        r36 = 27;
        goto L_0x0087;
    L_0x023e:
        r37 = "layout_marginTop";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x0248:
        r36 = 28;
        goto L_0x0087;
    L_0x024c:
        r37 = "layout_marginRight";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x0256:
        r36 = 29;
        goto L_0x0087;
    L_0x025a:
        r37 = "layout_marginBottom";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x0264:
        r36 = 30;
        goto L_0x0087;
    L_0x0268:
        r37 = "padding";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x0272:
        r36 = 31;
        goto L_0x0087;
    L_0x0276:
        r37 = "paddingLeft";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x0280:
        r36 = 32;
        goto L_0x0087;
    L_0x0284:
        r37 = "paddingTop";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x028e:
        r36 = 33;
        goto L_0x0087;
    L_0x0292:
        r37 = "paddingRight";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x029c:
        r36 = 34;
        goto L_0x0087;
    L_0x02a0:
        r37 = "paddingBottom";
        r0 = r37;
        r37 = r6.equals(r0);
        if (r37 == 0) goto L_0x0087;
    L_0x02aa:
        r36 = 35;
        goto L_0x0087;
    L_0x02ae:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r18 = defpackage.jg.b(r36);
        if (r42 == 0) goto L_0x008a;
    L_0x02ba:
        r19 = defpackage.jg.a(r42);
        r27 = b;
        r36 = r27 + 1;
        b = r36;
        r0 = r40;
        r1 = r27;
        r0.setId(r1);
        r0 = r19;
        r0 = r0.a;
        r36 = r0;
        r37 = java.lang.Integer.valueOf(r27);
        r0 = r36;
        r1 = r18;
        r2 = r37;
        r0.put(r1, r2);
        goto L_0x008a;
    L_0x02e0:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r37 = -1;
        r39 = r36.hashCode();
        switch(r39) {
            case 343327108: goto L_0x0318;
            case 1261922022: goto L_0x0327;
            case 1386124388: goto L_0x0336;
            default: goto L_0x02ef;
        };
    L_0x02ef:
        r36 = r37;
    L_0x02f1:
        switch(r36) {
            case 0: goto L_0x0345;
            case 1: goto L_0x034f;
            case 2: goto L_0x034f;
            default: goto L_0x02f4;
        };
    L_0x02f4:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r37 = r40.getResources();
        r37 = r37.getDisplayMetrics();
        r39 = 1;
        r0 = r36;
        r1 = r37;
        r2 = r42;
        r3 = r39;
        r36 = defpackage.jf.a(r0, r1, r2, r3);
        r0 = r36;
        r1 = r20;
        r1.width = r0;
        goto L_0x008a;
    L_0x0318:
        r39 = "wrap_content";
        r0 = r36;
        r1 = r39;
        r36 = r0.equals(r1);
        if (r36 == 0) goto L_0x02ef;
    L_0x0324:
        r36 = 0;
        goto L_0x02f1;
    L_0x0327:
        r39 = "fill_parent";
        r0 = r36;
        r1 = r39;
        r36 = r0.equals(r1);
        if (r36 == 0) goto L_0x02ef;
    L_0x0333:
        r36 = 1;
        goto L_0x02f1;
    L_0x0336:
        r39 = "match_parent";
        r0 = r36;
        r1 = r39;
        r36 = r0.equals(r1);
        if (r36 == 0) goto L_0x02ef;
    L_0x0342:
        r36 = 2;
        goto L_0x02f1;
    L_0x0345:
        r36 = -2;
        r0 = r36;
        r1 = r20;
        r1.width = r0;
        goto L_0x008a;
    L_0x034f:
        r36 = -1;
        r0 = r36;
        r1 = r20;
        r1.width = r0;
        goto L_0x008a;
    L_0x0359:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r37 = -1;
        r39 = r36.hashCode();
        switch(r39) {
            case 343327108: goto L_0x0391;
            case 1261922022: goto L_0x03a0;
            case 1386124388: goto L_0x03af;
            default: goto L_0x0368;
        };
    L_0x0368:
        r36 = r37;
    L_0x036a:
        switch(r36) {
            case 0: goto L_0x03be;
            case 1: goto L_0x03c8;
            case 2: goto L_0x03c8;
            default: goto L_0x036d;
        };
    L_0x036d:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r37 = r40.getResources();
        r37 = r37.getDisplayMetrics();
        r39 = 0;
        r0 = r36;
        r1 = r37;
        r2 = r42;
        r3 = r39;
        r36 = defpackage.jf.a(r0, r1, r2, r3);
        r0 = r36;
        r1 = r20;
        r1.height = r0;
        goto L_0x008a;
    L_0x0391:
        r39 = "wrap_content";
        r0 = r36;
        r1 = r39;
        r36 = r0.equals(r1);
        if (r36 == 0) goto L_0x0368;
    L_0x039d:
        r36 = 0;
        goto L_0x036a;
    L_0x03a0:
        r39 = "fill_parent";
        r0 = r36;
        r1 = r39;
        r36 = r0.equals(r1);
        if (r36 == 0) goto L_0x0368;
    L_0x03ac:
        r36 = 1;
        goto L_0x036a;
    L_0x03af:
        r39 = "match_parent";
        r0 = r36;
        r1 = r39;
        r36 = r0.equals(r1);
        if (r36 == 0) goto L_0x0368;
    L_0x03bb:
        r36 = 2;
        goto L_0x036a;
    L_0x03be:
        r36 = -2;
        r0 = r36;
        r1 = r20;
        r1.height = r0;
        goto L_0x008a;
    L_0x03c8:
        r36 = -1;
        r0 = r36;
        r1 = r20;
        r1.height = r0;
        goto L_0x008a;
    L_0x03d2:
        if (r42 == 0) goto L_0x03f2;
    L_0x03d4:
        r0 = r42;
        r0 = r0 instanceof android.widget.LinearLayout;
        r36 = r0;
        if (r36 == 0) goto L_0x03f2;
    L_0x03dc:
        r36 = r20;
        r36 = (android.widget.LinearLayout.LayoutParams) r36;
        r37 = r13.getValue();
        r37 = (java.lang.String) r37;
        r37 = defpackage.jg.c(r37);
        r0 = r37;
        r1 = r36;
        r1.gravity = r0;
        goto L_0x008a;
    L_0x03f2:
        if (r42 == 0) goto L_0x008a;
    L_0x03f4:
        r0 = r42;
        r0 = r0 instanceof android.widget.FrameLayout;
        r36 = r0;
        if (r36 == 0) goto L_0x008a;
    L_0x03fc:
        r36 = r20;
        r36 = (android.widget.FrameLayout.LayoutParams) r36;
        r37 = r13.getValue();
        r37 = (java.lang.String) r37;
        r37 = defpackage.jg.c(r37);
        r0 = r37;
        r1 = r36;
        r1.gravity = r0;
        goto L_0x008a;
    L_0x0412:
        if (r42 == 0) goto L_0x008a;
    L_0x0414:
        r0 = r42;
        r0 = r0 instanceof android.widget.LinearLayout;
        r36 = r0;
        if (r36 == 0) goto L_0x008a;
    L_0x041c:
        r36 = r20;
        r36 = (android.widget.LinearLayout.LayoutParams) r36;
        r37 = r13.getValue();
        r37 = (java.lang.String) r37;
        r37 = java.lang.Float.parseFloat(r37);
        r0 = r37;
        r1 = r36;
        r1.weight = r0;
        goto L_0x008a;
    L_0x0432:
        r21 = 3;
        r22 = 1;
        goto L_0x008a;
    L_0x0438:
        r21 = 2;
        r22 = 1;
        goto L_0x008a;
    L_0x043e:
        r21 = 0;
        r22 = 1;
        goto L_0x008a;
    L_0x0444:
        r21 = 1;
        r22 = 1;
        goto L_0x008a;
    L_0x044a:
        r21 = 8;
        r22 = 1;
        goto L_0x008a;
    L_0x0450:
        r21 = 6;
        r22 = 1;
        goto L_0x008a;
    L_0x0456:
        r21 = 5;
        r22 = 1;
        goto L_0x008a;
    L_0x045c:
        r21 = 7;
        r22 = 1;
        goto L_0x008a;
    L_0x0462:
        r21 = 12;
        goto L_0x008a;
    L_0x0466:
        r21 = 10;
        goto L_0x008a;
    L_0x046a:
        r21 = 9;
        goto L_0x008a;
    L_0x046e:
        r21 = 11;
        goto L_0x008a;
    L_0x0472:
        r21 = 14;
        goto L_0x008a;
    L_0x0476:
        r21 = 15;
        goto L_0x008a;
    L_0x047a:
        r21 = 13;
        goto L_0x008a;
    L_0x047e:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r37 = r40.getResources();
        r37 = r37.getDisplayMetrics();
        r23 = defpackage.jf.a(r36, r37);
        r26 = r23;
        r25 = r23;
        r24 = r23;
        goto L_0x008a;
    L_0x0498:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r37 = r40.getResources();
        r37 = r37.getDisplayMetrics();
        r39 = 1;
        r0 = r36;
        r1 = r37;
        r2 = r42;
        r3 = r39;
        r24 = defpackage.jf.a(r0, r1, r2, r3);
        goto L_0x008a;
    L_0x04b6:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r37 = r40.getResources();
        r37 = r37.getDisplayMetrics();
        r39 = 0;
        r0 = r36;
        r1 = r37;
        r2 = r42;
        r3 = r39;
        r26 = defpackage.jf.a(r0, r1, r2, r3);
        goto L_0x008a;
    L_0x04d4:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r37 = r40.getResources();
        r37 = r37.getDisplayMetrics();
        r39 = 1;
        r0 = r36;
        r1 = r37;
        r2 = r42;
        r3 = r39;
        r25 = defpackage.jf.a(r0, r1, r2, r3);
        goto L_0x008a;
    L_0x04f2:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r37 = r40.getResources();
        r37 = r37.getDisplayMetrics();
        r39 = 0;
        r0 = r36;
        r1 = r37;
        r2 = r42;
        r3 = r39;
        r23 = defpackage.jf.a(r0, r1, r2, r3);
        goto L_0x008a;
    L_0x0510:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r37 = r40.getResources();
        r37 = r37.getDisplayMetrics();
        r31 = defpackage.jf.a(r36, r37);
        r30 = r31;
        r29 = r31;
        r28 = r31;
        goto L_0x008a;
    L_0x052a:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r37 = r40.getResources();
        r37 = r37.getDisplayMetrics();
        r29 = defpackage.jf.a(r36, r37);
        goto L_0x008a;
    L_0x053e:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r37 = r40.getResources();
        r37 = r37.getDisplayMetrics();
        r31 = defpackage.jf.a(r36, r37);
        goto L_0x008a;
    L_0x0552:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r37 = r40.getResources();
        r37 = r37.getDisplayMetrics();
        r30 = defpackage.jf.a(r36, r37);
        goto L_0x008a;
    L_0x0566:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r37 = r40.getResources();
        r37 = r37.getDisplayMetrics();
        r28 = defpackage.jf.a(r36, r37);
        goto L_0x008a;
    L_0x057a:
        r36 = r13.getValue();
        r36 = (java.lang.String) r36;
        r37 = "true";
        r36 = r36.equals(r37);
        if (r36 == 0) goto L_0x0026;
    L_0x0588:
        r36 = r20;
        r36 = (android.widget.RelativeLayout.LayoutParams) r36;
        r0 = r36;
        r1 = r21;
        r0.addRule(r1);
        goto L_0x0026;
    L_0x0595:
        r36 = "background";
        r0 = r41;
        r1 = r36;
        r36 = r0.containsKey(r1);
        if (r36 != 0) goto L_0x05ad;
    L_0x05a1:
        r36 = "borderColor";
        r0 = r41;
        r1 = r36;
        r36 = r0.containsKey(r1);
        if (r36 == 0) goto L_0x05e0;
    L_0x05ad:
        r36 = "background";
        r0 = r41;
        r1 = r36;
        r36 = r0.containsKey(r1);
        if (r36 == 0) goto L_0x060e;
    L_0x05b9:
        r36 = "background";
        r0 = r41;
        r1 = r36;
        r36 = r0.get(r1);
        r36 = (java.lang.String) r36;
        r8 = r36;
    L_0x05c7:
        if (r8 == 0) goto L_0x0610;
    L_0x05c9:
        r36 = "@drawable/";
        r0 = r36;
        r36 = r8.startsWith(r0);
        if (r36 == 0) goto L_0x0610;
    L_0x05d3:
        r0 = r40;
        r36 = defpackage.jg.c(r0, r8);
        r0 = r40;
        r1 = r36;
        r0.setBackground(r1);
    L_0x05e0:
        r0 = r20;
        r0 = r0 instanceof android.view.ViewGroup.MarginLayoutParams;
        r36 = r0;
        if (r36 == 0) goto L_0x05f9;
    L_0x05e8:
        r36 = r20;
        r36 = (android.view.ViewGroup.MarginLayoutParams) r36;
        r0 = r36;
        r1 = r24;
        r2 = r26;
        r3 = r25;
        r4 = r23;
        r0.setMargins(r1, r2, r3, r4);
    L_0x05f9:
        r0 = r40;
        r1 = r29;
        r2 = r31;
        r3 = r30;
        r4 = r28;
        r0.setPadding(r1, r2, r3, r4);
        r0 = r40;
        r1 = r20;
        r0.setLayoutParams(r1);
        return;
    L_0x060e:
        r8 = 0;
        goto L_0x05c7;
    L_0x0610:
        if (r8 == 0) goto L_0x0626;
    L_0x0612:
        r36 = "#";
        r0 = r36;
        r36 = r8.startsWith(r0);
        if (r36 != 0) goto L_0x0626;
    L_0x061c:
        r36 = "@color";
        r0 = r36;
        r36 = r8.startsWith(r0);
        if (r36 == 0) goto L_0x05e0;
    L_0x0626:
        r0 = r40;
        r0 = r0 instanceof android.widget.Button;
        r36 = r0;
        if (r36 != 0) goto L_0x063a;
    L_0x062e:
        r36 = "pressedColor";
        r0 = r41;
        r1 = r36;
        r36 = r0.containsKey(r1);
        if (r36 == 0) goto L_0x07ce;
    L_0x063a:
        if (r8 != 0) goto L_0x063e;
    L_0x063c:
        r8 = "#00000000";
    L_0x063e:
        r0 = r40;
        r7 = defpackage.jg.b(r0, r8);
        r36 = "pressedColor";
        r0 = r41;
        r1 = r36;
        r36 = r0.containsKey(r1);
        if (r36 == 0) goto L_0x06fc;
    L_0x0650:
        r36 = "pressedColor";
        r0 = r41;
        r1 = r36;
        r36 = r0.get(r1);
        r36 = (java.lang.String) r36;
        r0 = r40;
        r1 = r36;
        r32 = defpackage.jg.b(r0, r1);
    L_0x0664:
        r14 = new android.graphics.drawable.GradientDrawable;
        r14.<init>();
        r14.setColor(r7);
        r33 = new android.graphics.drawable.GradientDrawable;
        r33.<init>();
        r0 = r33;
        r1 = r32;
        r0.setColor(r1);
        if (r15 == 0) goto L_0x0707;
    L_0x067a:
        r36 = 8;
        r0 = r36;
        r0 = new float[r0];
        r34 = r0;
        r17 = 0;
    L_0x0684:
        r36 = a;
        r0 = r36;
        r0 = r0.length;
        r36 = r0;
        r0 = r17;
        r1 = r36;
        if (r0 >= r1) goto L_0x0729;
    L_0x0691:
        r36 = a;
        r11 = r36[r17];
        r36 = new java.lang.StringBuilder;
        r36.<init>();
        r37 = "cornerRadius";
        r36 = r36.append(r37);
        r0 = r36;
        r36 = r0.append(r11);
        r36 = r36.toString();
        r0 = r41;
        r1 = r36;
        r36 = r0.containsKey(r1);
        if (r36 == 0) goto L_0x06f1;
    L_0x06b4:
        r37 = r17 * 2;
        r36 = r17 * 2;
        r38 = r36 + 1;
        r36 = new java.lang.StringBuilder;
        r36.<init>();
        r39 = "cornerRadius";
        r0 = r36;
        r1 = r39;
        r36 = r0.append(r1);
        r0 = r36;
        r36 = r0.append(r11);
        r36 = r36.toString();
        r0 = r41;
        r1 = r36;
        r36 = r0.get(r1);
        r36 = (java.lang.String) r36;
        r39 = r40.getResources();
        r39 = r39.getDisplayMetrics();
        r0 = r36;
        r1 = r39;
        r36 = defpackage.jf.b(r0, r1);
        r34[r38] = r36;
        r34[r37] = r36;
    L_0x06f1:
        r0 = r34;
        r14.setCornerRadii(r0);
        r33.setCornerRadii(r34);
        r17 = r17 + 1;
        goto L_0x0684;
    L_0x06fc:
        r36 = 1063675494; // 0x3f666666 float:0.9 double:5.2552552E-315;
        r0 = r36;
        r32 = defpackage.jg.a(r7, r0);
        goto L_0x0664;
    L_0x0707:
        if (r16 == 0) goto L_0x0729;
    L_0x0709:
        r36 = "cornerRadius";
        r0 = r41;
        r1 = r36;
        r36 = r0.get(r1);
        r36 = (java.lang.String) r36;
        r37 = r40.getResources();
        r37 = r37.getDisplayMetrics();
        r12 = defpackage.jf.b(r36, r37);
        r14.setCornerRadius(r12);
        r0 = r33;
        r0.setCornerRadius(r12);
    L_0x0729:
        r36 = "borderColor";
        r0 = r41;
        r1 = r36;
        r36 = r0.containsKey(r1);
        if (r36 == 0) goto L_0x0791;
    L_0x0735:
        r9 = "1dp";
        r36 = "borderWidth";
        r0 = r41;
        r1 = r36;
        r36 = r0.containsKey(r1);
        if (r36 == 0) goto L_0x074f;
    L_0x0743:
        r36 = "borderWidth";
        r0 = r41;
        r1 = r36;
        r9 = r0.get(r1);
        r9 = (java.lang.String) r9;
    L_0x074f:
        r36 = r40.getResources();
        r36 = r36.getDisplayMetrics();
        r0 = r36;
        r10 = defpackage.jf.a(r9, r0);
        r36 = "borderColor";
        r0 = r41;
        r1 = r36;
        r36 = r0.get(r1);
        r36 = (java.lang.String) r36;
        r0 = r40;
        r1 = r36;
        r36 = defpackage.jg.b(r0, r1);
        r0 = r36;
        r14.setStroke(r10, r0);
        r36 = "borderColor";
        r0 = r41;
        r1 = r36;
        r36 = r0.get(r1);
        r36 = (java.lang.String) r36;
        r0 = r40;
        r1 = r36;
        r36 = defpackage.jg.b(r0, r1);
        r0 = r33;
        r1 = r36;
        r0.setStroke(r10, r1);
    L_0x0791:
        r35 = new android.graphics.drawable.StateListDrawable;
        r35.<init>();
        r36 = 1;
        r0 = r36;
        r0 = new int[r0];
        r36 = r0;
        r37 = 0;
        r38 = 16842919; // 0x10100a7 float:2.3694026E-38 double:8.3215077E-317;
        r36[r37] = r38;
        r0 = r35;
        r1 = r36;
        r2 = r33;
        r0.addState(r1, r2);
        r36 = 0;
        r0 = r36;
        r0 = new int[r0];
        r36 = r0;
        r0 = r35;
        r1 = r36;
        r0.addState(r1, r14);
        r0 = r40;
        r1 = r35;
        r0.setBackground(r1);
        r36 = defpackage.jg.a(r40);
        r0 = r36;
        r0.c = r14;
        goto L_0x05e0;
    L_0x07ce:
        if (r16 != 0) goto L_0x07dc;
    L_0x07d0:
        r36 = "borderColor";
        r0 = r41;
        r1 = r36;
        r36 = r0.containsKey(r1);
        if (r36 == 0) goto L_0x08ea;
    L_0x07dc:
        r14 = new android.graphics.drawable.GradientDrawable;
        r14.<init>();
        if (r8 != 0) goto L_0x07e5;
    L_0x07e3:
        r8 = "#00000000";
    L_0x07e5:
        r0 = r40;
        r7 = defpackage.jg.b(r0, r8);
        r14.setColor(r7);
        if (r15 == 0) goto L_0x086f;
    L_0x07f0:
        r36 = 8;
        r0 = r36;
        r0 = new float[r0];
        r34 = r0;
        r17 = 0;
    L_0x07fa:
        r36 = a;
        r0 = r36;
        r0 = r0.length;
        r36 = r0;
        r0 = r17;
        r1 = r36;
        if (r0 >= r1) goto L_0x088c;
    L_0x0807:
        r36 = a;
        r11 = r36[r17];
        r36 = new java.lang.StringBuilder;
        r36.<init>();
        r37 = "cornerRadius";
        r36 = r36.append(r37);
        r0 = r36;
        r36 = r0.append(r11);
        r36 = r36.toString();
        r0 = r41;
        r1 = r36;
        r36 = r0.containsKey(r1);
        if (r36 == 0) goto L_0x0867;
    L_0x082a:
        r37 = r17 * 2;
        r36 = r17 * 2;
        r38 = r36 + 1;
        r36 = new java.lang.StringBuilder;
        r36.<init>();
        r39 = "cornerRadius";
        r0 = r36;
        r1 = r39;
        r36 = r0.append(r1);
        r0 = r36;
        r36 = r0.append(r11);
        r36 = r36.toString();
        r0 = r41;
        r1 = r36;
        r36 = r0.get(r1);
        r36 = (java.lang.String) r36;
        r39 = r40.getResources();
        r39 = r39.getDisplayMetrics();
        r0 = r36;
        r1 = r39;
        r36 = defpackage.jf.b(r0, r1);
        r34[r38] = r36;
        r34[r37] = r36;
    L_0x0867:
        r0 = r34;
        r14.setCornerRadii(r0);
        r17 = r17 + 1;
        goto L_0x07fa;
    L_0x086f:
        if (r16 == 0) goto L_0x088c;
    L_0x0871:
        r36 = "cornerRadius";
        r0 = r41;
        r1 = r36;
        r36 = r0.get(r1);
        r36 = (java.lang.String) r36;
        r37 = r40.getResources();
        r37 = r37.getDisplayMetrics();
        r12 = defpackage.jf.b(r36, r37);
        r14.setCornerRadius(r12);
    L_0x088c:
        r36 = "borderColor";
        r0 = r41;
        r1 = r36;
        r36 = r0.containsKey(r1);
        if (r36 == 0) goto L_0x08db;
    L_0x0898:
        r9 = "1dp";
        r36 = "borderWidth";
        r0 = r41;
        r1 = r36;
        r36 = r0.containsKey(r1);
        if (r36 == 0) goto L_0x08b2;
    L_0x08a6:
        r36 = "borderWidth";
        r0 = r41;
        r1 = r36;
        r9 = r0.get(r1);
        r9 = (java.lang.String) r9;
    L_0x08b2:
        r36 = r40.getResources();
        r36 = r36.getDisplayMetrics();
        r0 = r36;
        r37 = defpackage.jf.a(r9, r0);
        r36 = "borderColor";
        r0 = r41;
        r1 = r36;
        r36 = r0.get(r1);
        r36 = (java.lang.String) r36;
        r0 = r40;
        r1 = r36;
        r36 = defpackage.jg.b(r0, r1);
        r0 = r37;
        r1 = r36;
        r14.setStroke(r0, r1);
    L_0x08db:
        r0 = r40;
        r0.setBackground(r14);
        r36 = defpackage.jg.a(r40);
        r0 = r36;
        r0.c = r14;
        goto L_0x05e0;
    L_0x08ea:
        r0 = r40;
        r36 = defpackage.jg.b(r0, r8);
        r0 = r40;
        r1 = r36;
        r0.setBackgroundColor(r1);
        goto L_0x05e0;
        */
        throw new UnsupportedOperationException("Method not decompiled: jg.a(android.view.View, java.util.Map, android.view.ViewGroup):void");
    }

    private static jg$a a(View parent) {
        if (parent.getTag() != null && (parent.getTag() instanceof jg$a)) {
            return (jg$a) parent.getTag();
        }
        jg$a info = new jg$a();
        parent.setTag(info);
        return info;
    }

    private static OnClickListener b(ViewGroup myParent, String methodName) {
        return new jg$1(myParent, methodName);
    }

    private static String b(String value) {
        if (value.startsWith("@+id/")) {
            return value.substring(5);
        }
        if (value.startsWith("@id/")) {
            return value.substring(4);
        }
        return value;
    }

    private static int c(String value) {
        int gravity = 0;
        for (String part : value.toLowerCase().split("[|]")) {
            Object obj = -1;
            switch (part.hashCode()) {
                case -1417863058:
                    if (part.equals("textEnd")) {
                        obj = 4;
                        break;
                    }
                    break;
                case -1383228885:
                    if (part.equals("bottom")) {
                        obj = 6;
                        break;
                    }
                    break;
                case -1364013995:
                    if (part.equals("center")) {
                        obj = null;
                        break;
                    }
                    break;
                case -1048657099:
                    if (part.equals("textStart")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -348726240:
                    if (part.equals("center_vertical")) {
                        obj = 8;
                        break;
                    }
                    break;
                case 115029:
                    if (part.equals("top")) {
                        obj = 5;
                        break;
                    }
                    break;
                case 3317767:
                    if (part.equals("left")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 108511772:
                    if (part.equals("right")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 1063616078:
                    if (part.equals("center_horizontal")) {
                        obj = 7;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    gravity |= 17;
                    break;
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    gravity |= 3;
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    gravity |= 5;
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    gravity |= 48;
                    break;
                case um$h.CardView_cardUseCompatPadding /*6*/:
                    gravity |= 80;
                    break;
                case um$h.CardView_cardPreventCornerOverlap /*7*/:
                    gravity |= 1;
                    break;
                case um$h.CardView_contentPadding /*8*/:
                    gravity |= 16;
                    break;
                default:
                    break;
            }
        }
        return gravity;
    }

    public static int a(View view, String id) {
        if (!(view instanceof ViewGroup)) {
            return 0;
        }
        if (!(view.getTag() instanceof jg$a)) {
            return 0;
        }
        jg$a info = (jg$a) view.getTag();
        if (info.a.containsKey(id)) {
            return ((Integer) info.a.get(id)).intValue();
        }
        ViewGroup grp = (ViewGroup) view;
        for (int i = 0; i < grp.getChildCount(); i++) {
            int val = jg.a(grp.getChildAt(i), id);
            if (val != 0) {
                return val;
            }
        }
        return 0;
    }

    public static int b(View view, String text) {
        if (text.startsWith("@color/")) {
            Resources resources = view.getResources();
            return resources.getColor(resources.getIdentifier(text.substring("@color/".length()), "color", view.getContext().getPackageName()));
        }
        if (text.length() == 4 && text.startsWith("#")) {
            text = "#" + text.charAt(1) + text.charAt(1) + text.charAt(2) + text.charAt(2) + text.charAt(3) + text.charAt(3);
        }
        return Color.parseColor(text);
    }

    public static int a(int color, float amount) {
        return (((int) (((float) (color & 255)) * amount)) + (((int) (((float) (color & 255)) * amount)) << 8)) + (((int) (((float) (color & 255)) * amount)) << 16);
    }

    public static Drawable c(View view, String name) {
        Resources resources = view.getResources();
        return resources.getDrawable(resources.getIdentifier(name, "drawable", view.getContext().getPackageName()));
    }

    public static Drawable d(View view, String name) {
        Resources resources = view.getResources();
        return resources.getDrawable(resources.getIdentifier(name, "mipmap", view.getContext().getPackageName()));
    }

    public static void a() {
        c = new HashMap(30);
        c.put("scaleType", new jg$12());
        c.put("orientation", new jg$15());
        c.put("text", new jg$16());
        c.put("textSize", new jg$17());
        c.put("textColor", new jg$18());
        c.put("textStyle", new jg$19());
        c.put("textAlignment", new jg$20());
        c.put("ellipsize", new jg$21());
        c.put("singleLine", new jg$2());
        c.put("hint", new jg$3());
        c.put("inputType", new jg$4());
        c.put("gravity", new jg$5());
        c.put("src", new jg$6());
        c.put("visibility", new jg$7());
        c.put("alpha", new jg$8());
        c.put("textAllCaps", new jg$9());
        c.put("clickable", new jg$10());
        c.put("tag", new jg$11());
        c.put("onClick", new jg$13());
        c.put("elevation", new jg$14());
    }
}
