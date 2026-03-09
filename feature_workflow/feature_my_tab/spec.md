# 需求级 Spec：【我的】Tab 功能实现

> 路径：`feature_workflow/feature_my_tab/spec.md`。实现「我的」Tab 下的首版功能。

---

## 需求标识

- **需求名称/ID**：feature_my_tab（【我的】Tab）
- **关联项目 Spec**：`docs/PRODUCT_BRIEF.md`（产品 brief）
- **优先级**：P1

---

## 1. 范围（做什么）

- **用户故事/目标**：用户进入「我的」Tab，可查看/编辑昵称与头像、进入通用设置（主题/语言/通知/单位）、进入关于与反馈入口；数据仅存本机，无需登录。
- **验收标准**：
  - [ ] 我的页有清晰布局：顶部头像+昵称（可点击进入编辑），下列「设置」「关于」「反馈」等入口。
  - [ ] 昵称、头像（或占位图）可修改并持久化到本机。
  - [ ] 设置页包含：主题（亮/暗/跟随系统）、语言、通知开关、单位等可配置项，并持久化。
  - [ ] 关于页展示 App 名称、版本、简单说明；反馈可为占位（如按钮+文案，暂不实现提交逻辑）。
- **不做/边界**：
  - 不做账号登录、不做多端同步。
  - 反馈首版仅入口与占位，不实现真实提交或后端接口。
  - 头像首版可为占位图/默认图+本地选择图片（不要求裁剪、不要求云端）。

---

## 2. 接口与数据（输入输出）

- **涉及的数据/模型**：
  - **用户偏好**（本机）：`nickname: String`、`avatarUri: String?`（或本地路径/占位 key）、`theme: ThemeMode`、`language: String`、`notificationsEnabled: Boolean`、`unit: String`（如分钟、小时）等。放在 `shared` 或 `composeApp` 的 common 层，具体命名可定。
  - 持久化：本机存储（Android SharedPreferences/DataStore、JVM 本地文件、iOS UserDefaults 等），通过 expect/actual 或共用接口抽象。
- **涉及的后端/本地接口**：
  - 无远程 API；本地需：读/写用户偏好（如 `getUserPreferences()`、`saveUserPreferences(...)`）的接口或 ViewModel 暴露的 State/Flow。
- **涉及的前端/UI 入口**：
  - 「我的」Tab 已存在（`ProfileScreen`）；需改为完整页面：头像区、昵称、设置入口、关于入口、反馈入口。
  - 新页面/路由：编辑昵称（或弹窗）、设置页、关于页；反馈可为对话框或占位页。

---

## 3. 涉及文件与改动点

| 文件/模块 | 改动类型 | 说明 |
|-----------|----------|------|
| `composeApp/src/commonMain/.../screens/profile/ProfileScreen.kt` | 修改 | 替换占位为真实布局与入口 |
| `composeApp/src/commonMain/.../screens/profile/` 或 `profile/` 下 | 新增 | 可增子组件：头像区、设置入口列表、关于页、反馈占位等 |
| `shared` 或 `composeApp` commonMain | 新增/修改 | 用户偏好数据模型、持久化接口（expect/actual 或平台注入） |
| `composeApp` androidMain/jvmMain/iosMain | 新增/修改 | 本机存储实现（若用 expect/actual） |
| 主题/设置状态 | 新增/修改 | 主题在 App 级应用（如 MaterialTheme 或 CompositionLocalProvider），需在 App.kt 或根处消费偏好 |

- **新增目录/包**：如 `screens/profile/components`、`data/preferences` 或 `settings` 等按项目习惯。
- **依赖关系**：依赖现有 `App.kt` 与 `MainTab.Profile` 路由；不依赖其他 Tab 或 server。

---

## 4. 实现要点（怎么做）

- **步骤建议**（与 WORKFLOW 对应）：
  1. 在 shared/composeApp 定义用户偏好模型与「读/写偏好」的抽象；在各平台实现本机持久化。
  2. 实现「我的」主页面布局：头像（可点）、昵称（可点）、列表项「设置」「关于」「反馈」；点击昵称/头像进入编辑（昵称可弹窗或简单页，头像可选图或占位）。
  3. 实现设置页：主题、语言、通知、单位等控件，写入偏好并令主题等在 App 级生效。
  4. 实现关于页（静态文案+版本）；反馈为按钮+占位文案或简单占位页。
- **注意点/坑**：
  - KMP 下本机存储需用 expect/actual 或依赖注入，避免在 commonMain 直接写平台 API。
  - 主题切换需在根 Composable 或 Activity 层应用，避免只改设置页不生效。
  - UI 保持「简单、清晰」（与 PRODUCT_BRIEF 一致）。

---

## 5. 测试/验收提示

- 如何自测：在 Desktop 与 Android 上切换 Tab 到「我的」，改昵称/主题等，重启 App 检查持久化；检查设置页各项生效。
- 需要检查的端/机型：Desktop (JVM)、Android；iOS 若有实现则一并检查。

---

## 变更记录

| 日期 | 变更 |
|------|------|
| 初版 | 根据 PRODUCT_BRIEF 编写 |
