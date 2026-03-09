# Spec 定义

Spec = 规约。先定「做什么、怎么做」，再让 AI 按 Spec 生成代码，提高可控性、降低 token（不必反复试错）。

---

## 两级 Spec

| 级别 | 用途 | 模板 | 建议放置位置 |
|------|------|------|----------------|
| **项目级** | 技术栈、结构、约定、大模块 | `_template_project_spec.md` | 项目根 `docs/spec_project.md` 或本目录 |
| **需求级** | 单功能/单需求的范围与实现要点 | `_template_requirement_spec.md` | 需求子文件夹下的 `spec.md` 或 `spec/requirement/<需求名>.md` |

---

## 使用方式

1. **新项目**：复制 `_template_project_spec.md`，填好后放在项目里；新对话时让 AI「先读项目 Spec 再动手」。
2. **新需求**：复制 `_template_requirement_spec.md`，填好范围、接口、文件；让 AI「按该需求 Spec 实现」。
3. **小需求**：可在需求子文件夹下建一个短 `spec.md`（几行也行），只写「改哪几处、输入输出是什么」。

---

## 原则

- Spec 由人审、人改；AI 负责按 Spec 生成/修改代码。
- 需求级 Spec 可引用项目级 Spec（如「遵循项目 Spec 的模块划分」）。
