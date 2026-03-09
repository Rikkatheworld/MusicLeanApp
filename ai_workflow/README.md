# AI Workflow 模板库

> 目标：无论 demo 还是公司大项目、无论大需求还是小需求，都能用这套模板 + Workflow，让 **50%+ 代码由 AI 生成**，同时 **大幅降低 token 使用量**。

---

## 目录结构

```
ai_workflow/
├── README.md                 # 本文件：总览与使用方式
├── spec/                     # 1. Spec 定义（项目级 / 需求级）
├── workflow/                 # 2. Workflow 模板（大流程 → 子任务 WBS）
├── context/                  # 3. 渐进式上下文
└── rules_and_skills/         # 4. 专属规则与 Skill
```

---

## 使用方式速查

| 场景 | 用哪个 | 放在哪 |
|------|--------|--------|
| 新项目 / 大方向 | 项目级 Spec | `spec/` 或项目根 `docs/spec_project.md` |
| 单个需求 / 功能 | 需求级 Spec | `spec/requirement/` 或需求子文件夹下的 `spec.md` |
| 复杂任务拆解执行 | Workflow | `workflow/` 或项目下 `docs/workflow/xxx/WORKFLOW.md` |
| 控制「何时给 AI 什么信息」 | 渐进式上下文 | 按 `context/` 模板在对话中分步提供 |
| 项目/团队约定、可复用能力 | 规则 + Skill | `.cursor/rules/` + `rules_and_skills/` 中的 Skill |

---

## 推荐流程（降低 token + 提高可用性）

1. **先写 Spec**（项目级或需求级）→ 你或 AI 按模板填，再让 AI 按 Spec 写代码。
2. **大需求拆 Workflow** → 用 `workflow/_template_workflow.md` 写步骤，每步可再拆到 `_template_step.md`。
3. **对话时用渐进式上下文** → 先给结构/索引，再按需贴文件或片段（见 `context/`）。
4. **沉淀规则与 Skill** → 项目约定写进规则，可复用流程写进 Skill，新对话先加载再执行。

---

## 与 Cursor 的配合

- **规则**：放在 `.cursor/rules/` 下的 `.mdc` 或说明文件，Cursor 会自动作为上下文。
- **Skill**：放在 `rules_and_skills/skills/`，需要时在对话中让 AI「先读取 `ai_workflow/rules_and_skills/skills/xxx.md` 再执行」。
- **Workflow**：可在对话开始时发「按 `ai_workflow/workflow/xxx/WORKFLOW.md` 执行」，或把关键步骤贴进第一条消息。

---

各子目录下均有 `README.md` 与 `_template_*.md`，按需复制、重命名、填写即可。
