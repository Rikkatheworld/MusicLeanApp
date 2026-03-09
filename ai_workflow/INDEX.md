# AI Workflow 模板索引

快速找到要用的模板。

---

## 1. Spec

| 我要… | 用这个文件 |
|-------|------------|
| 定义整个项目的技术栈、结构、约定 | `spec/_template_project_spec.md` |
| 定义单个需求的范围与实现要点 | `spec/_template_requirement_spec.md` |
| 放需求级 Spec 的目录 | `spec/requirement/` |

---

## 2. Workflow

| 我要… | 用这个文件 |
|-------|------------|
| 定义一条任务的大步骤编排 | `workflow/_template_workflow.md` |
| 定义某一步的细粒度子任务（WBS） | `workflow/_template_step.md` |
| 先收集复杂入参再执行工作流 | `workflow/_template_workflow_init.md` |
| 放某条工作流的细分子任务 | `workflow/steps/`（或在工作流目录下建 steps） |

---

## 3. 渐进式上下文

| 我要… | 用这个文件 |
|-------|------------|
| 控制「何时给 AI 什么信息」、减少 token | `context/_template_progressive_context.md` |

---

## 4. 规则与 Skill

| 我要… | 用这个文件 |
|-------|------------|
| 写一条项目/团队规则（必须/禁止/建议） | `rules_and_skills/_template_rule.md` |
| 写一条可复用的 Skill | `rules_and_skills/_template_skill.md` |
| 只列 Skill 名单供渐进式拉取 | `rules_and_skills/_template_skill_list.md` |
| 放规则文件 | `rules_and_skills/rules/` 或 `.cursor/rules/` |
| 放 Skill 文件 | `rules_and_skills/skills/` |

---

## 目标回顾

- **Spec**：项目级 + 需求级，先定再做，提高 AI 代码可用性。
- **Workflow**：大步骤 → 子任务 WBS，按步执行，降低遗漏。
- **渐进式上下文**：先给结构/索引，按步贴文件，大幅降低 token。
- **规则/Skill**：约定写进规则，能力写进 Skill，新对话先加载再执行。

**结果**：无论 demo 还是公司大项目、大需求还是小需求，都能用这套模板，让 50%+ 代码由 AI 生成，同时大幅降低 token 使用量。
