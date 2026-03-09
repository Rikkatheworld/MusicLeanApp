# STEP_01：用户偏好数据层（WBS）

> 实现「我的」Tab 所需的本地数据：模型 + 读/写接口 + 各平台持久化。

---

## 本步目标

在 common 层定义用户偏好模型与「读/写偏好」的抽象，并在 Android/JVM/iOS 实现本机持久化，供后续「我的」页与设置页使用。

---

## 输入

- 来自上一步的产物：无（首步）
- 本步需要的额外文件/路径：`shared/src/commonMain` 或 `composeApp/src/commonMain` 的包结构；现有 `shared` 的 `build.gradle.kts`
- 本步需要遵循的 Spec/Skill：`feature_workflow/feature_my_tab/spec.md` 第 2 节

---

## 执行要点

1. **common 层**：定义数据类（如 `UserPreferences`），包含：`nickname`、`avatarUriOrKey`、`theme`（枚举：Light/Dark/System）、`language`、`notificationsEnabled`、`unit` 等；定义默认值。
2. **common 层**：定义「读偏好」「写偏好」的接口或 expect 声明（如 `PreferenceRepository` 或 `getUserPreferences()` / `saveUserPreferences(...)`），仅依赖 common 可用的类型。
3. **各平台**：在 androidMain 用 DataStore 或 SharedPreferences；在 jvmMain 用本地文件（如 properties/json）；在 iosMain 用 UserDefaults。通过 expect/actual 或接口+平台注入提供实现。
4. 确保 common 不依赖平台 API；调用方（ViewModel 或 Composable 状态）在拿到实现后能读/写并观察变化（如 Flow/StateFlow）。

---

## 输出/交付

- 新增/修改的文件：common 中模型与接口；androidMain/jvmMain/iosMain 各一份实现（或共享的 expect/actual 文件）
- 可检查的产物：编译通过；可写单测或临时调用读/写验证持久化（可选）

---

## 完成标准

- [ ] common 中有 `UserPreferences`（或等价）及读/写抽象
- [ ] Android、JVM 至少两端的持久化实现存在且编译通过
- [ ] 无在 commonMain 中直接引用平台 API

---

## 注意/坑

- KMP 下 prefer expect/actual 或接口+多平台 provide，避免 common 依赖 android/ios/jvm 包。
- 若用 DataStore，注意 composeApp 的 androidMain 依赖；JVM 可用 java.util.prefs 或简单文件。
- 主题枚举需与 Compose Material 的 Dark/Light/System 对齐，便于 Step 3 使用。
