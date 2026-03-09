# Workflow：【我的】Tab 功能实现

> 路径：`feature_workflow/feature_my_tab/WORKFLOW.md`。按步实现「我的」Tab 的 Spec，每步可细化为 steps/STEP_xx.md。

---

## 前置条件

- **适用项目/场景**：rikka_guitar_app，Compose Multiplatform（Android / iOS / Desktop）。
- **前置依赖**：已有底部 4 Tab 与 `ProfileScreen` 占位；无其他功能依赖。
- **可选入参**：无，按本目录 `spec.md` 即可。

---

## 本工作流用到的 Skill / 规约

| 名称 | 路径/说明 |
|------|------------|
| 需求 Spec | 本目录 `spec.md` |
| 产品 brief | `docs/PRODUCT_BRIEF.md`（我的 Tab 范围） |

---

## 步骤编排（大方向）

### Step 1：用户偏好数据层

- **目标**：定义用户偏好模型（昵称、头像、主题、语言、通知、单位等）与本机读/写接口，并在各平台实现持久化。
- **输入**：无；参考 `spec.md` 第 2 节。
- **输出/交付**：common 层模型 + 读/写接口；androidMain/jvmMain/iosMain 的存储实现；无 UI。
- **使用 Skill/规约**：`spec.md`
- **细分子任务**：见 `steps/STEP_01.md`

---

### Step 2：「我的」主页面布局与头像/昵称

- **目标**：替换 `ProfileScreen` 占位为真实布局：顶部头像+昵称（可点击编辑），下列「设置」「关于」「反馈」入口。
- **输入**：Step 1 的偏好读/写能力；当前 `ProfileScreen.kt`。
- **输出/交付**：`ProfileScreen` 完整 UI；昵称编辑（弹窗或小页）；头像展示（占位或本地选图）。
- **使用 Skill/规约**：`spec.md`
- **细分子任务**：见 `steps/STEP_02.md`

---

### Step 3：设置页（主题、语言、通知、单位）

- **目标**：设置页包含主题、语言、通知、单位等项，修改后写入偏好并在 App 级生效（如主题切换）。
- **输入**：Step 1 的偏好接口；Step 2 的「设置」入口。
- **输出/交付**：设置页 UI + 与偏好联动；主题在根处应用。
- **使用 Skill/规约**：`spec.md`
- **细分子任务**：见 `steps/STEP_03.md`

---

### Step 4：关于页与反馈入口（反馈占位）

- **目标**：关于页展示 App 名、版本、说明；反馈为入口+占位（不实现提交逻辑）。
- **输入**：Step 2 的「关于」「反馈」入口。
- **输出/交付**：关于页静态内容；反馈按钮/页占位。
- **使用 Skill/规约**：`spec.md`
- **细分子任务**：见 `steps/STEP_04.md`

---

## 收尾与检查

- [ ] 所有步骤输出已达成
- [ ] `./gradlew :composeApp:compileDebugKotlinAndroid` 与 `:composeApp:compileKotlinJvm` 通过
- [ ] 在 Desktop 与 Android 上手动走一遍：我的 → 改昵称/主题 → 重启确认持久化；设置、关于、反馈入口可进入

---

## 变更记录

| 日期 | 变更 |
|------|------|
| 初版 | 与 spec.md 对齐 |
