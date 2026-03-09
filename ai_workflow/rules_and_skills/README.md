# 规则与 Skill

- **规则（Rules）**：项目/团队约定，告诉 AI「必须/禁止」怎么做，减少误用和风格不一致。适合放在 `.cursor/rules/`，Cursor 会作为上下文。
- **Skill**：可复用的「能力说明」或「小流程」，按需在对话中让 AI 读取后再执行，实现渐进式上下文。

---

## 规则（Rules）

| 内容 | 建议放置 | 说明 |
|------|----------|------|
| 项目级约定 | `.cursor/rules/project.mdc` 或本目录 `rules/` | 技术栈、目录、命名、禁止项 |
| 语言/框架级 | `.cursor/rules/kotlin.mdc` 等 | 语言风格、框架使用方式 |
| 需求级约束 | 需求文件夹下的 `rule.md` 或 Spec 内「不要」一节 | 本需求的禁止/必须 |

使用：在 Cursor 中规则会自动加载；或在新对话首条说「请先读 `ai_workflow/rules_and_skills/rules/xxx.md`」。

---

## Skill

| 内容 | 建议放置 | 说明 |
|------|----------|------|
| 单条 Skill | `skills/<name>.md` | 一个能力一份文件，写清输入、步骤、输出 |
| Skill 列表 | 见下方模板 | 只列名称+简短描述，对话中按需「拉取」具体 Skill 内容 |

使用：首条消息只给「Skill 列表」；某步需要时再说「请按 `ai_workflow/rules_and_skills/skills/xxx.md` 执行」。

---

## 原则

- 规则尽量短、可执行（禁止/必须清晰）。
- Skill 单职责、可被多条 Workflow 复用。
