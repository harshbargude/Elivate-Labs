// src/api.ts
export type Note = {
  id: number; title: string; content: string;
  createdAt: string; updatedAt: string;
};

const API = (import.meta as any).env.VITE_API_URL ?? 'http://localhost:8080/api';

export async function listNotes(): Promise<Note[]> {
  const r = await fetch(`${API}/notes`);
  if (!r.ok) throw new Error('fetch notes failed');
  return r.json();
}
export async function createNote(data: {title: string; content: string;}): Promise<Note> {
  const r = await fetch(`${API}/notes`, { method:'POST', headers:{'Content-Type':'application/json'},
    body: JSON.stringify(data) });
  if (!r.ok) throw new Error('create failed');
  return r.json();
}
export async function updateNote(id: number, data: {title: string; content: string;}): Promise<Note> {
  const r = await fetch(`${API}/notes/${id}`, { method:'PUT', headers:{'Content-Type':'application/json'},
    body: JSON.stringify(data) });
  if (!r.ok) throw new Error('update failed');
  return r.json();
}
export async function deleteNote(id: number): Promise<void> {
  const r = await fetch(`${API}/notes/${id}`, { method:'DELETE' });
  if (!r.ok) throw new Error('delete failed');
}