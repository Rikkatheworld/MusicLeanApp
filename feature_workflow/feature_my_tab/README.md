# 【我的】Tab 需求与工作流

本目录包含「我的」Tab 的完整需求与分步实现工作流，按 `ai_workflow` 模板编写。

---

## 文件说明

| 文件 | 说明 |
|------|------|
| **spec.md** | 需求级 Spec：范围、数据、涉及文件、实现要点、验收 |
| **WORKFLOW.md** | 大方向步骤编排：Step 1～4 与收尾检查 |
| **steps/STEP_01.md** | 用户偏好数据层（模型 + 本机持久化） |
| **steps/STEP_02.md** | 「我的」主页面布局 + 头像/昵称编辑 |
| **steps/STEP_03.md** | 设置页（主题、语言、通知、单位） |
| **steps/STEP_04.md** | 关于页 + 反馈入口占位 |

---

## 使用方式

- **你或 AI 实现时**：先读 `spec.md`，再按 `WORKFLOW.md` 顺序执行；每步细节见 `steps/STEP_xx.md`。
- **对话中**：可发「按 `feature_workflow/feature_my_tab/spec.md` 和 `WORKFLOW.md` 实现【我的】Tab」，或按步执行「先做 STEP_01，再做 STEP_02」。
- **渐进式上下文**：第一步只给 spec + STEP_01；第二步再给 STEP_02 + 已改动的文件路径；依此类推，减少 token。

---

## 验收

- 见 `spec.md` 第 1 节验收标准与 `WORKFLOW.md` 收尾检查。
