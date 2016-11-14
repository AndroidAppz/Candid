package defpackage;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Build.VERSION;
import com.crashlytics.android.core.CodedOutputStream;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: SessionProtobufHelper */
class tl {
    private static final so a = so.a("0");
    private static final so b = so.a("Unity");

    public static void a(CodedOutputStream cos, String sessionId, String generator, long startedAtSeconds) throws Exception {
        cos.a(1, so.a(generator));
        cos.a(2, so.a(sessionId));
        cos.a(3, startedAtSeconds);
    }

    public static void a(CodedOutputStream cos, String packageName, String apiKey, String versionCode, String versionName, String installUuid, int deliveryMechanism, String unityVersion) throws Exception {
        so packageNameBytes = so.a(packageName);
        so apiKeyBytes = so.a(apiKey);
        so versionCodeBytes = so.a(versionCode);
        so versionNameBytes = so.a(versionName);
        so installIdBytes = so.a(installUuid);
        so unityVersionBytes = unityVersion != null ? so.a(unityVersion) : null;
        cos.g(7, 2);
        cos.k(tl.a(packageNameBytes, apiKeyBytes, versionCodeBytes, versionNameBytes, installIdBytes, deliveryMechanism, unityVersionBytes));
        cos.a(1, packageNameBytes);
        cos.a(2, versionCodeBytes);
        cos.a(3, versionNameBytes);
        cos.g(5, 2);
        cos.k(tl.a(apiKeyBytes));
        cos.a(1, apiKeyBytes);
        cos.a(6, installIdBytes);
        if (unityVersionBytes != null) {
            cos.a(8, b);
            cos.a(9, unityVersionBytes);
        }
        cos.b(10, deliveryMechanism);
    }

    public static void a(CodedOutputStream cos, boolean isRooted) throws Exception {
        so releaseBytes = so.a(VERSION.RELEASE);
        so codeNameBytes = so.a(VERSION.CODENAME);
        cos.g(8, 2);
        cos.k(tl.a(releaseBytes, codeNameBytes, isRooted));
        cos.b(1, 3);
        cos.a(2, releaseBytes);
        cos.a(3, codeNameBytes);
        cos.a(4, isRooted);
    }

    public static void a(CodedOutputStream cos, String clsDeviceId, int arch, String model, int availableProcessors, long totalRam, long diskSpace, boolean isEmulator, Map<DeviceIdentifierType, String> ids, int state, String manufacturer, String modelClass) throws Exception {
        so clsDeviceIDBytes = so.a(clsDeviceId);
        so modelBytes = tl.a(model);
        so modelClassBytes = tl.a(modelClass);
        so manufacturerBytes = tl.a(manufacturer);
        cos.g(9, 2);
        cos.k(tl.a(arch, clsDeviceIDBytes, modelBytes, availableProcessors, totalRam, diskSpace, isEmulator, (Map) ids, state, manufacturerBytes, modelClassBytes));
        cos.a(1, clsDeviceIDBytes);
        cos.b(3, arch);
        cos.a(4, modelBytes);
        cos.a(5, availableProcessors);
        cos.a(6, totalRam);
        cos.a(7, diskSpace);
        cos.a(10, isEmulator);
        for (Entry<DeviceIdentifierType, String> id : ids.entrySet()) {
            cos.g(11, 2);
            cos.k(tl.a((DeviceIdentifierType) id.getKey(), (String) id.getValue()));
            cos.b(1, ((DeviceIdentifierType) id.getKey()).h);
            cos.a(2, so.a((String) id.getValue()));
        }
        cos.a(12, state);
        if (manufacturerBytes != null) {
            cos.a(13, manufacturerBytes);
        }
        if (modelClassBytes != null) {
            cos.a(14, modelClassBytes);
        }
    }

    public static void a(CodedOutputStream cos, String id, String name, String email) throws Exception {
        if (id == null) {
            id = "";
        }
        so idBytes = so.a(id);
        so nameBytes = tl.a(name);
        so emailBytes = tl.a(email);
        int size = 0 + CodedOutputStream.b(1, idBytes);
        if (name != null) {
            size += CodedOutputStream.b(2, nameBytes);
        }
        if (email != null) {
            size += CodedOutputStream.b(3, emailBytes);
        }
        cos.g(6, 2);
        cos.k(size);
        cos.a(1, idBytes);
        if (name != null) {
            cos.a(2, nameBytes);
        }
        if (email != null) {
            cos.a(3, emailBytes);
        }
    }

    public static void a(CodedOutputStream cos, long eventTime, String eventType, Throwable exception, Thread exceptionThread, StackTraceElement[] exceptionStack, Thread[] otherThreads, List<StackTraceElement[]> otherStacks, Map<String, String> customAttributes, td logFileManager, RunningAppProcessInfo runningAppProcessInfo, int orientation, String packageName, String buildId, float batteryLevel, int batteryVelocity, boolean proximityEnabled, long usedRamInBytes, long diskUsedInBytes) throws Exception {
        so optionalBuildIdBytes;
        so packageNameBytes = so.a(packageName);
        if (buildId == null) {
            optionalBuildIdBytes = null;
        } else {
            optionalBuildIdBytes = so.a(buildId.replace("-", ""));
        }
        so logByteString = logFileManager.a();
        if (logByteString == null) {
            akp.h().a("CrashlyticsCore", "No log data to include with this event.");
        }
        logFileManager.b();
        cos.g(10, 2);
        cos.k(tl.a(eventTime, eventType, exception, exceptionThread, exceptionStack, otherThreads, (List) otherStacks, 8, (Map) customAttributes, runningAppProcessInfo, orientation, packageNameBytes, optionalBuildIdBytes, batteryLevel, batteryVelocity, proximityEnabled, usedRamInBytes, diskUsedInBytes, logByteString));
        cos.a(1, eventTime);
        cos.a(2, so.a(eventType));
        tl.a(cos, exception, exceptionThread, exceptionStack, otherThreads, (List) otherStacks, 8, packageNameBytes, optionalBuildIdBytes, (Map) customAttributes, runningAppProcessInfo, orientation);
        tl.a(cos, batteryLevel, batteryVelocity, proximityEnabled, orientation, usedRamInBytes, diskUsedInBytes);
        tl.a(cos, logByteString);
    }

    private static void a(CodedOutputStream cos, Throwable exception, Thread exceptionThread, StackTraceElement[] exceptionStack, Thread[] otherThreads, List<StackTraceElement[]> otherStacks, int maxChainedExceptionsDepth, so packageNameBytes, so optionalBuildIdBytes, Map<String, String> customAttributes, RunningAppProcessInfo runningAppProcessInfo, int orientation) throws Exception {
        cos.g(3, 2);
        cos.k(tl.a(exception, exceptionThread, exceptionStack, otherThreads, (List) otherStacks, maxChainedExceptionsDepth, packageNameBytes, optionalBuildIdBytes, (Map) customAttributes, runningAppProcessInfo, orientation));
        tl.a(cos, exception, exceptionThread, exceptionStack, otherThreads, otherStacks, maxChainedExceptionsDepth, packageNameBytes, optionalBuildIdBytes);
        if (!(customAttributes == null || customAttributes.isEmpty())) {
            tl.a(cos, (Map) customAttributes);
        }
        if (runningAppProcessInfo != null) {
            cos.a(3, runningAppProcessInfo.importance != 100);
        }
        cos.a(4, orientation);
    }

    private static void a(CodedOutputStream cos, Throwable exception, Thread exceptionThread, StackTraceElement[] exceptionStack, Thread[] otherThreads, List<StackTraceElement[]> otherStacks, int maxChainedExceptionsDepth, so packageNameBytes, so optionalBuildIdBytes) throws Exception {
        cos.g(1, 2);
        cos.k(tl.a(exception, exceptionThread, exceptionStack, otherThreads, (List) otherStacks, maxChainedExceptionsDepth, packageNameBytes, optionalBuildIdBytes));
        tl.a(cos, exceptionThread, exceptionStack, 4, true);
        int len = otherThreads.length;
        for (int i = 0; i < len; i++) {
            tl.a(cos, otherThreads[i], (StackTraceElement[]) otherStacks.get(i), 0, false);
        }
        tl.a(cos, exception, 1, maxChainedExceptionsDepth, 2);
        cos.g(3, 2);
        cos.k(tl.a());
        cos.a(1, a);
        cos.a(2, a);
        cos.a(3, 0);
        cos.g(4, 2);
        cos.k(tl.a(packageNameBytes, optionalBuildIdBytes));
        cos.a(1, 0);
        cos.a(2, 0);
        cos.a(3, packageNameBytes);
        if (optionalBuildIdBytes != null) {
            cos.a(4, optionalBuildIdBytes);
        }
    }

    private static void a(CodedOutputStream cos, Map<String, String> customAttributes) throws Exception {
        for (Entry<String, String> entry : customAttributes.entrySet()) {
            cos.g(2, 2);
            cos.k(tl.a((String) entry.getKey(), (String) entry.getValue()));
            cos.a(1, so.a((String) entry.getKey()));
            String value = (String) entry.getValue();
            if (value == null) {
                value = "";
            }
            cos.a(2, so.a(value));
        }
    }

    private static void a(CodedOutputStream cos, Throwable exception, int chainDepth, int maxChainedExceptionsDepth, int field) throws Exception {
        cos.g(field, 2);
        cos.k(tl.a(exception, 1, maxChainedExceptionsDepth));
        cos.a(1, so.a(exception.getClass().getName()));
        String message = exception.getLocalizedMessage();
        if (message != null) {
            cos.a(3, so.a(message));
        }
        for (StackTraceElement element : exception.getStackTrace()) {
            tl.a(cos, 4, element, true);
        }
        Throwable cause = exception.getCause();
        if (cause == null) {
            return;
        }
        if (chainDepth < maxChainedExceptionsDepth) {
            tl.a(cos, cause, chainDepth + 1, maxChainedExceptionsDepth, 6);
            return;
        }
        int overflowCount = 0;
        while (cause != null) {
            cause = cause.getCause();
            overflowCount++;
        }
        cos.a(7, overflowCount);
    }

    private static void a(CodedOutputStream cos, Thread thread, StackTraceElement[] stackTraceElements, int importance, boolean isCrashedThread) throws Exception {
        cos.g(1, 2);
        cos.k(tl.a(thread, stackTraceElements, importance, isCrashedThread));
        cos.a(1, so.a(thread.getName()));
        cos.a(2, importance);
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            tl.a(cos, 3, stackTraceElement, isCrashedThread);
        }
    }

    private static void a(CodedOutputStream cos, int fieldIndex, StackTraceElement element, boolean isCrashedThread) throws Exception {
        int i = 4;
        cos.g(fieldIndex, 2);
        cos.k(tl.a(element, isCrashedThread));
        if (element.isNativeMethod()) {
            cos.a(1, (long) Math.max(element.getLineNumber(), 0));
        } else {
            cos.a(1, 0);
        }
        cos.a(2, so.a(element.getClassName() + "." + element.getMethodName()));
        if (element.getFileName() != null) {
            cos.a(3, so.a(element.getFileName()));
        }
        if (!element.isNativeMethod() && element.getLineNumber() > 0) {
            cos.a(4, (long) element.getLineNumber());
        }
        if (!isCrashedThread) {
            i = 0;
        }
        cos.a(5, i);
    }

    private static void a(CodedOutputStream cos, float batteryLevel, int batteryVelocity, boolean proximityEnabled, int orientation, long heapAllocatedSize, long diskUsed) throws Exception {
        cos.g(5, 2);
        cos.k(tl.a(batteryLevel, batteryVelocity, proximityEnabled, orientation, heapAllocatedSize, diskUsed));
        cos.a(1, batteryLevel);
        cos.c(2, batteryVelocity);
        cos.a(3, proximityEnabled);
        cos.a(4, orientation);
        cos.a(5, heapAllocatedSize);
        cos.a(6, diskUsed);
    }

    private static void a(CodedOutputStream cos, so log) throws Exception {
        if (log != null) {
            cos.g(6, 2);
            cos.k(tl.b(log));
            cos.a(1, log);
        }
    }

    private static int a(so packageName, so apiKey, so versionCode, so versionName, so installUuid, int deliveryMechanism, so unityVersion) {
        int size = ((0 + CodedOutputStream.b(1, packageName)) + CodedOutputStream.b(2, versionCode)) + CodedOutputStream.b(3, versionName);
        int orgSize = tl.a(apiKey);
        size = (size + ((CodedOutputStream.j(5) + CodedOutputStream.l(orgSize)) + orgSize)) + CodedOutputStream.b(6, installUuid);
        if (unityVersion != null) {
            size = (size + CodedOutputStream.b(8, b)) + CodedOutputStream.b(9, unityVersion);
        }
        return size + CodedOutputStream.e(10, deliveryMechanism);
    }

    private static int a(so apiKey) {
        return 0 + CodedOutputStream.b(1, apiKey);
    }

    private static int a(so release, so codeName, boolean isRooted) {
        return (((0 + CodedOutputStream.e(1, 3)) + CodedOutputStream.b(2, release)) + CodedOutputStream.b(3, codeName)) + CodedOutputStream.b(4, isRooted);
    }

    private static int a(DeviceIdentifierType type, String value) {
        return CodedOutputStream.e(1, type.h) + CodedOutputStream.b(2, so.a(value));
    }

    private static int a(int arch, so clsDeviceID, so model, int availableProcessors, long totalRam, long diskSpace, boolean isEmulator, Map<DeviceIdentifierType, String> ids, int state, so manufacturer, so modelClass) {
        int i;
        int size = (0 + CodedOutputStream.b(1, clsDeviceID)) + CodedOutputStream.e(3, arch);
        if (model == null) {
            i = 0;
        } else {
            i = CodedOutputStream.b(4, model);
        }
        size = ((((size + i) + CodedOutputStream.d(5, availableProcessors)) + CodedOutputStream.b(6, totalRam)) + CodedOutputStream.b(7, diskSpace)) + CodedOutputStream.b(10, isEmulator);
        if (ids != null) {
            for (Entry<DeviceIdentifierType, String> id : ids.entrySet()) {
                int idSize = tl.a((DeviceIdentifierType) id.getKey(), (String) id.getValue());
                size += (CodedOutputStream.j(11) + CodedOutputStream.l(idSize)) + idSize;
            }
        }
        return ((size + CodedOutputStream.d(12, state)) + (manufacturer == null ? 0 : CodedOutputStream.b(13, manufacturer))) + (modelClass == null ? 0 : CodedOutputStream.b(14, modelClass));
    }

    private static int a(so packageNameBytes, so optionalBuildIdBytes) {
        int size = ((0 + CodedOutputStream.b(1, 0)) + CodedOutputStream.b(2, 0)) + CodedOutputStream.b(3, packageNameBytes);
        if (optionalBuildIdBytes != null) {
            return size + CodedOutputStream.b(4, optionalBuildIdBytes);
        }
        return size;
    }

    private static int a(long eventTime, String eventType, Throwable exception, Thread exceptionThread, StackTraceElement[] exceptionStack, Thread[] otherThreads, List<StackTraceElement[]> otherStacks, int maxChainedExceptionsDepth, Map<String, String> customAttributes, RunningAppProcessInfo runningAppProcessInfo, int orientation, so packageNameBytes, so optionalBuildIdBytes, float batteryLevel, int batteryVelocity, boolean proximityEnabled, long heapAllocatedSize, long diskUsed, so log) {
        int size = (0 + CodedOutputStream.b(1, eventTime)) + CodedOutputStream.b(2, so.a(eventType));
        int eventAppSize = tl.a(exception, exceptionThread, exceptionStack, otherThreads, (List) otherStacks, maxChainedExceptionsDepth, packageNameBytes, optionalBuildIdBytes, (Map) customAttributes, runningAppProcessInfo, orientation);
        size += (CodedOutputStream.j(3) + CodedOutputStream.l(eventAppSize)) + eventAppSize;
        int eventDeviceSize = tl.a(batteryLevel, batteryVelocity, proximityEnabled, orientation, heapAllocatedSize, diskUsed);
        size += (CodedOutputStream.j(5) + CodedOutputStream.l(eventDeviceSize)) + eventDeviceSize;
        if (log == null) {
            return size;
        }
        int logSize = tl.b(log);
        return size + ((CodedOutputStream.j(6) + CodedOutputStream.l(logSize)) + logSize);
    }

    private static int a(Throwable exception, Thread exceptionThread, StackTraceElement[] exceptionStack, Thread[] otherThreads, List<StackTraceElement[]> otherStacks, int maxChainedExceptionsDepth, so packageNameBytes, so optionalBuildIdBytes, Map<String, String> customAttributes, RunningAppProcessInfo runningAppProcessInfo, int orientation) {
        int executionSize = tl.a(exception, exceptionThread, exceptionStack, otherThreads, (List) otherStacks, maxChainedExceptionsDepth, packageNameBytes, optionalBuildIdBytes);
        int size = 0 + ((CodedOutputStream.j(1) + CodedOutputStream.l(executionSize)) + executionSize);
        if (customAttributes != null) {
            for (Entry<String, String> entry : customAttributes.entrySet()) {
                int entrySize = tl.a((String) entry.getKey(), (String) entry.getValue());
                size += (CodedOutputStream.j(2) + CodedOutputStream.l(entrySize)) + entrySize;
            }
        }
        if (runningAppProcessInfo != null) {
            size += CodedOutputStream.b(3, runningAppProcessInfo.importance != 100);
        }
        return size + CodedOutputStream.d(4, orientation);
    }

    private static int a(Throwable exception, Thread exceptionThread, StackTraceElement[] exceptionStack, Thread[] otherThreads, List<StackTraceElement[]> otherStacks, int maxChainedExceptionDepth, so packageNameBytes, so optionalBuildIdBytes) {
        int threadSize = tl.a(exceptionThread, exceptionStack, 4, true);
        int size = 0 + ((CodedOutputStream.j(1) + CodedOutputStream.l(threadSize)) + threadSize);
        int len = otherThreads.length;
        for (int i = 0; i < len; i++) {
            threadSize = tl.a(otherThreads[i], (StackTraceElement[]) otherStacks.get(i), 0, false);
            size += (CodedOutputStream.j(1) + CodedOutputStream.l(threadSize)) + threadSize;
        }
        int exceptionSize = tl.a(exception, 1, maxChainedExceptionDepth);
        size += (CodedOutputStream.j(2) + CodedOutputStream.l(exceptionSize)) + exceptionSize;
        int signalSize = tl.a();
        size += (CodedOutputStream.j(3) + CodedOutputStream.l(signalSize)) + signalSize;
        int binaryImageSize = tl.a(packageNameBytes, optionalBuildIdBytes);
        return size + ((CodedOutputStream.j(3) + CodedOutputStream.l(binaryImageSize)) + binaryImageSize);
    }

    private static int a(String key, String value) {
        int size = CodedOutputStream.b(1, so.a(key));
        if (value == null) {
            value = "";
        }
        return size + CodedOutputStream.b(2, so.a(value));
    }

    private static int a(float batteryLevel, int batteryVelocity, boolean proximityEnabled, int orientation, long heapAllocatedSize, long diskUsed) {
        return (((((0 + CodedOutputStream.b(1, batteryLevel)) + CodedOutputStream.f(2, batteryVelocity)) + CodedOutputStream.b(3, proximityEnabled)) + CodedOutputStream.d(4, orientation)) + CodedOutputStream.b(5, heapAllocatedSize)) + CodedOutputStream.b(6, diskUsed);
    }

    private static int b(so log) {
        return CodedOutputStream.b(1, log);
    }

    private static int a(Throwable ex, int chainDepth, int maxChainedExceptionsDepth) {
        int size = 0 + CodedOutputStream.b(1, so.a(ex.getClass().getName()));
        String message = ex.getLocalizedMessage();
        if (message != null) {
            size += CodedOutputStream.b(3, so.a(message));
        }
        for (StackTraceElement element : ex.getStackTrace()) {
            int frameSize = tl.a(element, true);
            size += (CodedOutputStream.j(4) + CodedOutputStream.l(frameSize)) + frameSize;
        }
        Throwable cause = ex.getCause();
        if (cause == null) {
            return size;
        }
        if (chainDepth < maxChainedExceptionsDepth) {
            int exceptionSize = tl.a(cause, chainDepth + 1, maxChainedExceptionsDepth);
            return size + ((CodedOutputStream.j(6) + CodedOutputStream.l(exceptionSize)) + exceptionSize);
        }
        int overflowCount = 0;
        while (cause != null) {
            cause = cause.getCause();
            overflowCount++;
        }
        return size + CodedOutputStream.d(7, overflowCount);
    }

    private static int a() {
        return ((0 + CodedOutputStream.b(1, a)) + CodedOutputStream.b(2, a)) + CodedOutputStream.b(3, 0);
    }

    private static int a(StackTraceElement element, boolean isCrashedThread) {
        int size;
        int i = 2;
        if (element.isNativeMethod()) {
            size = 0 + CodedOutputStream.b(1, (long) Math.max(element.getLineNumber(), 0));
        } else {
            size = 0 + CodedOutputStream.b(1, 0);
        }
        size += CodedOutputStream.b(2, so.a(element.getClassName() + "." + element.getMethodName()));
        if (element.getFileName() != null) {
            size += CodedOutputStream.b(3, so.a(element.getFileName()));
        }
        if (!element.isNativeMethod() && element.getLineNumber() > 0) {
            size += CodedOutputStream.b(4, (long) element.getLineNumber());
        }
        if (!isCrashedThread) {
            i = 0;
        }
        return size + CodedOutputStream.d(5, i);
    }

    private static int a(Thread thread, StackTraceElement[] stackTraceElements, int importance, boolean isCrashedThread) {
        int size = CodedOutputStream.b(1, so.a(thread.getName())) + CodedOutputStream.d(2, importance);
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            int frameSize = tl.a(stackTraceElement, isCrashedThread);
            size += (CodedOutputStream.j(3) + CodedOutputStream.l(frameSize)) + frameSize;
        }
        return size;
    }

    private static so a(String s) {
        return s == null ? null : so.a(s);
    }
}
