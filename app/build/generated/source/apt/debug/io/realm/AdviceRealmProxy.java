package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.ProxyUtils;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class AdviceRealmProxy extends com.example.user.fuckinggreatadvicegetter.Advice
    implements RealmObjectProxy, AdviceRealmProxyInterface {

    static final class AdviceColumnInfo extends ColumnInfo {
        long adviceIndex;
        long idIndex;

        AdviceColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Advice");
            this.adviceIndex = addColumnDetails("advice", objectSchemaInfo);
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
        }

        AdviceColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new AdviceColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final AdviceColumnInfo src = (AdviceColumnInfo) rawSrc;
            final AdviceColumnInfo dst = (AdviceColumnInfo) rawDst;
            dst.adviceIndex = src.adviceIndex;
            dst.idIndex = src.idIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(2);
        fieldNames.add("advice");
        fieldNames.add("id");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private AdviceColumnInfo columnInfo;
    private ProxyState<com.example.user.fuckinggreatadvicegetter.Advice> proxyState;

    AdviceRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (AdviceColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.user.fuckinggreatadvicegetter.Advice>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$advice() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.adviceIndex);
    }

    @Override
    public void realmSet$advice(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.adviceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.adviceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.adviceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.adviceIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Advice", 2, 0);
        builder.addPersistedProperty("advice", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static AdviceColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new AdviceColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Advice";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.user.fuckinggreatadvicegetter.Advice createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.user.fuckinggreatadvicegetter.Advice obj = realm.createObjectInternal(com.example.user.fuckinggreatadvicegetter.Advice.class, true, excludeFields);

        final AdviceRealmProxyInterface objProxy = (AdviceRealmProxyInterface) obj;
        if (json.has("advice")) {
            if (json.isNull("advice")) {
                objProxy.realmSet$advice(null);
            } else {
                objProxy.realmSet$advice((String) json.getString("advice"));
            }
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.user.fuckinggreatadvicegetter.Advice createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.user.fuckinggreatadvicegetter.Advice obj = new com.example.user.fuckinggreatadvicegetter.Advice();
        final AdviceRealmProxyInterface objProxy = (AdviceRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("advice")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$advice((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$advice(null);
                }
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.example.user.fuckinggreatadvicegetter.Advice copyOrUpdate(Realm realm, com.example.user.fuckinggreatadvicegetter.Advice object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.user.fuckinggreatadvicegetter.Advice) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.example.user.fuckinggreatadvicegetter.Advice copy(Realm realm, com.example.user.fuckinggreatadvicegetter.Advice newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.user.fuckinggreatadvicegetter.Advice) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.user.fuckinggreatadvicegetter.Advice realmObject = realm.createObjectInternal(com.example.user.fuckinggreatadvicegetter.Advice.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        AdviceRealmProxyInterface realmObjectSource = (AdviceRealmProxyInterface) newObject;
        AdviceRealmProxyInterface realmObjectCopy = (AdviceRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$advice(realmObjectSource.realmGet$advice());
        realmObjectCopy.realmSet$id(realmObjectSource.realmGet$id());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.user.fuckinggreatadvicegetter.Advice object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.user.fuckinggreatadvicegetter.Advice.class);
        long tableNativePtr = table.getNativePtr();
        AdviceColumnInfo columnInfo = (AdviceColumnInfo) realm.getSchema().getColumnInfo(com.example.user.fuckinggreatadvicegetter.Advice.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$advice = ((AdviceRealmProxyInterface) object).realmGet$advice();
        if (realmGet$advice != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.adviceIndex, rowIndex, realmGet$advice, false);
        }
        String realmGet$id = ((AdviceRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.user.fuckinggreatadvicegetter.Advice.class);
        long tableNativePtr = table.getNativePtr();
        AdviceColumnInfo columnInfo = (AdviceColumnInfo) realm.getSchema().getColumnInfo(com.example.user.fuckinggreatadvicegetter.Advice.class);
        com.example.user.fuckinggreatadvicegetter.Advice object = null;
        while (objects.hasNext()) {
            object = (com.example.user.fuckinggreatadvicegetter.Advice) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$advice = ((AdviceRealmProxyInterface) object).realmGet$advice();
            if (realmGet$advice != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.adviceIndex, rowIndex, realmGet$advice, false);
            }
            String realmGet$id = ((AdviceRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.user.fuckinggreatadvicegetter.Advice object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.user.fuckinggreatadvicegetter.Advice.class);
        long tableNativePtr = table.getNativePtr();
        AdviceColumnInfo columnInfo = (AdviceColumnInfo) realm.getSchema().getColumnInfo(com.example.user.fuckinggreatadvicegetter.Advice.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$advice = ((AdviceRealmProxyInterface) object).realmGet$advice();
        if (realmGet$advice != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.adviceIndex, rowIndex, realmGet$advice, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.adviceIndex, rowIndex, false);
        }
        String realmGet$id = ((AdviceRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.user.fuckinggreatadvicegetter.Advice.class);
        long tableNativePtr = table.getNativePtr();
        AdviceColumnInfo columnInfo = (AdviceColumnInfo) realm.getSchema().getColumnInfo(com.example.user.fuckinggreatadvicegetter.Advice.class);
        com.example.user.fuckinggreatadvicegetter.Advice object = null;
        while (objects.hasNext()) {
            object = (com.example.user.fuckinggreatadvicegetter.Advice) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$advice = ((AdviceRealmProxyInterface) object).realmGet$advice();
            if (realmGet$advice != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.adviceIndex, rowIndex, realmGet$advice, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.adviceIndex, rowIndex, false);
            }
            String realmGet$id = ((AdviceRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
            }
        }
    }

    public static com.example.user.fuckinggreatadvicegetter.Advice createDetachedCopy(com.example.user.fuckinggreatadvicegetter.Advice realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.user.fuckinggreatadvicegetter.Advice unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.user.fuckinggreatadvicegetter.Advice();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.user.fuckinggreatadvicegetter.Advice) cachedObject.object;
            }
            unmanagedObject = (com.example.user.fuckinggreatadvicegetter.Advice) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        AdviceRealmProxyInterface unmanagedCopy = (AdviceRealmProxyInterface) unmanagedObject;
        AdviceRealmProxyInterface realmSource = (AdviceRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$advice(realmSource.realmGet$advice());
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Advice = proxy[");
        stringBuilder.append("{advice:");
        stringBuilder.append(realmGet$advice() != null ? realmGet$advice() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdviceRealmProxy aAdvice = (AdviceRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aAdvice.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aAdvice.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aAdvice.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
