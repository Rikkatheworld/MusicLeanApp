# Workflow 模板

Workflow = 把复杂任务拆成「步骤 + 每步用到的 Skill/规约」，让 AI 按顺序执行，减少遗漏和乱用上下文。

---

## 颗粒度（从大到小）

| 层级 | 文件/用法 | 说明 |
|------|-----------|------|
| **大方向流程** | `WORKFLOW.md`（或 `_template_workflow.md`） | 整条需求/任务的步骤编排，每步可指向子 Workflow 或 Skill |
| **单步/子任务（WBS）** | `_template_step.md` 或步骤目录下的 `STEP_xx.md` | 单步的输入、输出、检查点、可用的 Skill/规则 |
| **复杂入参** | `WORKFLOW_INIT.md`（或 `_template_workflow_init.md`） | 需要先让 AI 生成「结构化问卷」再填写的场景 |

---

## 使用方式

1. **新任务**：复制 `_template_workflow.md` 为 `WORKFLOW.md`，填步骤；需要时为某步建 `STEP_01.md` 等。
2. **对话中**：第一条消息发「按 `ai_workflow/workflow/xxx/WORKFLOW.md` 执行」，或贴 Workflow 关键步骤。
3. **与 Spec 配合**：Workflow 里可写「第 2 步：按需求 Spec `spec/requirement/xxx.md` 实现界面」。

---

## 原则

- 每一步只做一件事，输出明确（文件/接口/检查点）。
- 大流程里的每一步可再拆成更细的 STEP，形成 WBS。
