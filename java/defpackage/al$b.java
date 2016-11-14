package defpackage;

import android.graphics.Path;
import android.util.Log;

/* compiled from: PathParser */
public class al$b {
    char a;
    float[] b;

    private al$b(char type, float[] params) {
        this.a = type;
        this.b = params;
    }

    private al$b(al$b n) {
        this.a = n.a;
        this.b = al.b(n.b, 0, n.b.length);
    }

    public static void a(al$b[] node, Path path) {
        float[] current = new float[6];
        char previousCommand = 'm';
        for (int i = 0; i < node.length; i++) {
            al$b.a(path, current, previousCommand, node[i].a, node[i].b);
            previousCommand = node[i].a;
        }
    }

    private static void a(Path path, float[] current, char previousCmd, char cmd, float[] val) {
        int incr = 2;
        float currentX = current[0];
        float currentY = current[1];
        float ctrlPointX = current[2];
        float ctrlPointY = current[3];
        float currentSegmentStartX = current[4];
        float currentSegmentStartY = current[5];
        switch (cmd) {
            case ha$a.AppCompatTheme_textAppearanceSearchResultTitle /*65*/:
            case ha$a.AppCompatTheme_buttonBarNegativeButtonStyle /*97*/:
                incr = 7;
                break;
            case ha$a.AppCompatTheme_textColorSearchUrl /*67*/:
            case ha$a.AppCompatTheme_autoCompleteTextViewStyle /*99*/:
                incr = 6;
                break;
            case ha$a.AppCompatTheme_listPreferredItemPaddingLeft /*72*/:
            case ha$a.AppCompatTheme_colorControlActivated /*86*/:
            case ha$a.AppCompatTheme_editTextStyle /*104*/:
            case 'v':
                incr = 1;
                break;
            case ha$a.AppCompatTheme_textAppearanceListItem /*76*/:
            case ha$a.AppCompatTheme_textAppearanceListItemSmall /*77*/:
            case ha$a.AppCompatTheme_colorAccent /*84*/:
            case ha$a.AppCompatTheme_ratingBarStyleSmall /*108*/:
            case ha$a.AppCompatTheme_seekBarStyle /*109*/:
            case 't':
                incr = 2;
                break;
            case ha$a.AppCompatTheme_listChoiceBackgroundIndicator /*81*/:
            case ha$a.AppCompatTheme_colorPrimaryDark /*83*/:
            case 'q':
            case 's':
                incr = 4;
                break;
            case ha$a.AppCompatTheme_controlBackground /*90*/:
            case 'z':
                path.close();
                currentX = currentSegmentStartX;
                currentY = currentSegmentStartY;
                ctrlPointX = currentSegmentStartX;
                ctrlPointY = currentSegmentStartY;
                path.moveTo(currentX, currentY);
                break;
        }
        for (int k = 0; k < val.length; k += incr) {
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            boolean z;
            boolean z2;
            float reflectiveCtrlPointX;
            float reflectiveCtrlPointY;
            switch (cmd) {
                case ha$a.AppCompatTheme_textAppearanceSearchResultTitle /*65*/:
                    f = val[k + 5];
                    f2 = val[k + 6];
                    f3 = val[k + 0];
                    f4 = val[k + 1];
                    f5 = val[k + 2];
                    z = val[k + 3] != 0.0f;
                    if (val[k + 4] != 0.0f) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    al$b.a(path, currentX, currentY, f, f2, f3, f4, f5, z, z2);
                    currentX = val[k + 5];
                    currentY = val[k + 6];
                    ctrlPointX = currentX;
                    ctrlPointY = currentY;
                    break;
                case ha$a.AppCompatTheme_textColorSearchUrl /*67*/:
                    path.cubicTo(val[k + 0], val[k + 1], val[k + 2], val[k + 3], val[k + 4], val[k + 5]);
                    currentX = val[k + 4];
                    currentY = val[k + 5];
                    ctrlPointX = val[k + 2];
                    ctrlPointY = val[k + 3];
                    break;
                case ha$a.AppCompatTheme_listPreferredItemPaddingLeft /*72*/:
                    path.lineTo(val[k + 0], currentY);
                    currentX = val[k + 0];
                    break;
                case ha$a.AppCompatTheme_textAppearanceListItem /*76*/:
                    path.lineTo(val[k + 0], val[k + 1]);
                    currentX = val[k + 0];
                    currentY = val[k + 1];
                    break;
                case ha$a.AppCompatTheme_textAppearanceListItemSmall /*77*/:
                    currentX = val[k + 0];
                    currentY = val[k + 1];
                    if (k <= 0) {
                        path.moveTo(val[k + 0], val[k + 1]);
                        currentSegmentStartX = currentX;
                        currentSegmentStartY = currentY;
                        break;
                    }
                    path.lineTo(val[k + 0], val[k + 1]);
                    break;
                case ha$a.AppCompatTheme_listChoiceBackgroundIndicator /*81*/:
                    path.quadTo(val[k + 0], val[k + 1], val[k + 2], val[k + 3]);
                    ctrlPointX = val[k + 0];
                    ctrlPointY = val[k + 1];
                    currentX = val[k + 2];
                    currentY = val[k + 3];
                    break;
                case ha$a.AppCompatTheme_colorPrimaryDark /*83*/:
                    reflectiveCtrlPointX = currentX;
                    reflectiveCtrlPointY = currentY;
                    if (previousCmd == 'c' || previousCmd == 's' || previousCmd == 'C' || previousCmd == 'S') {
                        reflectiveCtrlPointX = (2.0f * currentX) - ctrlPointX;
                        reflectiveCtrlPointY = (2.0f * currentY) - ctrlPointY;
                    }
                    path.cubicTo(reflectiveCtrlPointX, reflectiveCtrlPointY, val[k + 0], val[k + 1], val[k + 2], val[k + 3]);
                    ctrlPointX = val[k + 0];
                    ctrlPointY = val[k + 1];
                    currentX = val[k + 2];
                    currentY = val[k + 3];
                    break;
                case ha$a.AppCompatTheme_colorAccent /*84*/:
                    reflectiveCtrlPointX = currentX;
                    reflectiveCtrlPointY = currentY;
                    if (previousCmd == 'q' || previousCmd == 't' || previousCmd == 'Q' || previousCmd == 'T') {
                        reflectiveCtrlPointX = (2.0f * currentX) - ctrlPointX;
                        reflectiveCtrlPointY = (2.0f * currentY) - ctrlPointY;
                    }
                    path.quadTo(reflectiveCtrlPointX, reflectiveCtrlPointY, val[k + 0], val[k + 1]);
                    ctrlPointX = reflectiveCtrlPointX;
                    ctrlPointY = reflectiveCtrlPointY;
                    currentX = val[k + 0];
                    currentY = val[k + 1];
                    break;
                case ha$a.AppCompatTheme_colorControlActivated /*86*/:
                    path.lineTo(currentX, val[k + 0]);
                    currentY = val[k + 0];
                    break;
                case ha$a.AppCompatTheme_buttonBarNegativeButtonStyle /*97*/:
                    f = val[k + 5] + currentX;
                    f2 = val[k + 6] + currentY;
                    f3 = val[k + 0];
                    f4 = val[k + 1];
                    f5 = val[k + 2];
                    z = val[k + 3] != 0.0f;
                    if (val[k + 4] != 0.0f) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    al$b.a(path, currentX, currentY, f, f2, f3, f4, f5, z, z2);
                    currentX += val[k + 5];
                    currentY += val[k + 6];
                    ctrlPointX = currentX;
                    ctrlPointY = currentY;
                    break;
                case ha$a.AppCompatTheme_autoCompleteTextViewStyle /*99*/:
                    path.rCubicTo(val[k + 0], val[k + 1], val[k + 2], val[k + 3], val[k + 4], val[k + 5]);
                    ctrlPointX = currentX + val[k + 2];
                    ctrlPointY = currentY + val[k + 3];
                    currentX += val[k + 4];
                    currentY += val[k + 5];
                    break;
                case ha$a.AppCompatTheme_editTextStyle /*104*/:
                    path.rLineTo(val[k + 0], 0.0f);
                    currentX += val[k + 0];
                    break;
                case ha$a.AppCompatTheme_ratingBarStyleSmall /*108*/:
                    path.rLineTo(val[k + 0], val[k + 1]);
                    currentX += val[k + 0];
                    currentY += val[k + 1];
                    break;
                case ha$a.AppCompatTheme_seekBarStyle /*109*/:
                    currentX += val[k + 0];
                    currentY += val[k + 1];
                    if (k <= 0) {
                        path.rMoveTo(val[k + 0], val[k + 1]);
                        currentSegmentStartX = currentX;
                        currentSegmentStartY = currentY;
                        break;
                    }
                    path.rLineTo(val[k + 0], val[k + 1]);
                    break;
                case 'q':
                    path.rQuadTo(val[k + 0], val[k + 1], val[k + 2], val[k + 3]);
                    ctrlPointX = currentX + val[k + 0];
                    ctrlPointY = currentY + val[k + 1];
                    currentX += val[k + 2];
                    currentY += val[k + 3];
                    break;
                case 's':
                    reflectiveCtrlPointX = 0.0f;
                    reflectiveCtrlPointY = 0.0f;
                    if (previousCmd == 'c' || previousCmd == 's' || previousCmd == 'C' || previousCmd == 'S') {
                        reflectiveCtrlPointX = currentX - ctrlPointX;
                        reflectiveCtrlPointY = currentY - ctrlPointY;
                    }
                    path.rCubicTo(reflectiveCtrlPointX, reflectiveCtrlPointY, val[k + 0], val[k + 1], val[k + 2], val[k + 3]);
                    ctrlPointX = currentX + val[k + 0];
                    ctrlPointY = currentY + val[k + 1];
                    currentX += val[k + 2];
                    currentY += val[k + 3];
                    break;
                case 't':
                    reflectiveCtrlPointX = 0.0f;
                    reflectiveCtrlPointY = 0.0f;
                    if (previousCmd == 'q' || previousCmd == 't' || previousCmd == 'Q' || previousCmd == 'T') {
                        reflectiveCtrlPointX = currentX - ctrlPointX;
                        reflectiveCtrlPointY = currentY - ctrlPointY;
                    }
                    path.rQuadTo(reflectiveCtrlPointX, reflectiveCtrlPointY, val[k + 0], val[k + 1]);
                    ctrlPointX = currentX + reflectiveCtrlPointX;
                    ctrlPointY = currentY + reflectiveCtrlPointY;
                    currentX += val[k + 0];
                    currentY += val[k + 1];
                    break;
                case 'v':
                    path.rLineTo(0.0f, val[k + 0]);
                    currentY += val[k + 0];
                    break;
                default:
                    break;
            }
            previousCmd = cmd;
        }
        current[0] = currentX;
        current[1] = currentY;
        current[2] = ctrlPointX;
        current[3] = ctrlPointY;
        current[4] = currentSegmentStartX;
        current[5] = currentSegmentStartY;
    }

    private static void a(Path p, float x0, float y0, float x1, float y1, float a, float b, float theta, boolean isMoreThanHalf, boolean isPositiveArc) {
        double thetaD = Math.toRadians((double) theta);
        double cosTheta = Math.cos(thetaD);
        double sinTheta = Math.sin(thetaD);
        double x0p = ((((double) x0) * cosTheta) + (((double) y0) * sinTheta)) / ((double) a);
        double y0p = ((((double) (-x0)) * sinTheta) + (((double) y0) * cosTheta)) / ((double) b);
        double x1p = ((((double) x1) * cosTheta) + (((double) y1) * sinTheta)) / ((double) a);
        double y1p = ((((double) (-x1)) * sinTheta) + (((double) y1) * cosTheta)) / ((double) b);
        double dx = x0p - x1p;
        double dy = y0p - y1p;
        double xm = (x0p + x1p) / 2.0d;
        double ym = (y0p + y1p) / 2.0d;
        double dsq = (dx * dx) + (dy * dy);
        if (dsq == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double disc = (1.0d / dsq) - 0.25d;
        if (disc < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + dsq);
            float adjust = (float) (Math.sqrt(dsq) / 1.99999d);
            al$b.a(p, x0, y0, x1, y1, a * adjust, b * adjust, theta, isMoreThanHalf, isPositiveArc);
            return;
        }
        double cx;
        double cy;
        double s = Math.sqrt(disc);
        double sdx = s * dx;
        double sdy = s * dy;
        if (isMoreThanHalf == isPositiveArc) {
            cx = xm - sdy;
            cy = ym + sdx;
        } else {
            cx = xm + sdy;
            cy = ym - sdx;
        }
        double eta0 = Math.atan2(y0p - cy, x0p - cx);
        double sweep = Math.atan2(y1p - cy, x1p - cx) - eta0;
        if (isPositiveArc != (sweep >= 0.0d)) {
            if (sweep > 0.0d) {
                sweep -= 6.283185307179586d;
            } else {
                sweep += 6.283185307179586d;
            }
        }
        cx *= (double) a;
        cy *= (double) b;
        al$b.a(p, (cx * cosTheta) - (cy * sinTheta), (cx * sinTheta) + (cy * cosTheta), (double) a, (double) b, (double) x0, (double) y0, thetaD, eta0, sweep);
    }

    private static void a(Path p, double cx, double cy, double a, double b, double e1x, double e1y, double theta, double start, double sweep) {
        int numSegments = (int) Math.ceil(Math.abs((4.0d * sweep) / 3.141592653589793d));
        double eta1 = start;
        double cosTheta = Math.cos(theta);
        double sinTheta = Math.sin(theta);
        double cosEta1 = Math.cos(eta1);
        double sinEta1 = Math.sin(eta1);
        double ep1x = (((-a) * cosTheta) * sinEta1) - ((b * sinTheta) * cosEta1);
        double ep1y = (((-a) * sinTheta) * sinEta1) + ((b * cosTheta) * cosEta1);
        double anglePerSegment = sweep / ((double) numSegments);
        for (int i = 0; i < numSegments; i++) {
            double eta2 = eta1 + anglePerSegment;
            double sinEta2 = Math.sin(eta2);
            double cosEta2 = Math.cos(eta2);
            double e2x = (((a * cosTheta) * cosEta2) + cx) - ((b * sinTheta) * sinEta2);
            double e2y = (((a * sinTheta) * cosEta2) + cy) + ((b * cosTheta) * sinEta2);
            double ep2x = (((-a) * cosTheta) * sinEta2) - ((b * sinTheta) * cosEta2);
            double ep2y = (((-a) * sinTheta) * sinEta2) + ((b * cosTheta) * cosEta2);
            double tanDiff2 = Math.tan((eta2 - eta1) / 2.0d);
            double alpha = (Math.sin(eta2 - eta1) * (Math.sqrt(4.0d + ((3.0d * tanDiff2) * tanDiff2)) - 1.0d)) / 3.0d;
            Path path = p;
            path.cubicTo((float) (e1x + (alpha * ep1x)), (float) (e1y + (alpha * ep1y)), (float) (e2x - (alpha * ep2x)), (float) (e2y - (alpha * ep2y)), (float) e2x, (float) e2y);
            eta1 = eta2;
            e1x = e2x;
            e1y = e2y;
            ep1x = ep2x;
            ep1y = ep2y;
        }
    }
}
