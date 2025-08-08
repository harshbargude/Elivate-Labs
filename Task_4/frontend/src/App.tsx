import "./App.css";
import "./style/output.css";

import { useEffect, useState } from 'react';
import { listNotes, createNote, updateNote, deleteNote, Note } from './api';

export default function App() {
  const [notes, setNotes] = useState<Note[]>([]);
  const [selected, setSelected] = useState<Note | null>(null);
  const [title, setTitle] = useState(''); const [content, setContent] = useState('');
  const [loading, setLoading] = useState(true); const [err, setErr] = useState<string|undefined>();

  useEffect(() => { (async () => {
    try { setNotes(await listNotes()); } catch(e:any){ setErr(e.message); }
    finally { setLoading(false); }
  })(); }, []);

  function pick(n: Note) { setSelected(n); setTitle(n.title); setContent(n.content); }

  async function save() {
    try {
      if (selected) {
        const u = await updateNote(selected.id, { title, content });
        setNotes(ns => ns.map(n => n.id === u.id ? u : n));
        setSelected(u);
      } else {
        const c = await createNote({ title, content });
        setNotes(ns => [c, ...ns]); setSelected(c);
      }
      setTitle(''); setContent('');
    } catch(e:any) { alert(e.message); }
  }
  async function destroy(id:number) {
    if (!confirm('Delete note?')) return;
    try { await deleteNote(id); setNotes(ns => ns.filter(n => n.id !== id)); if (selected?.id===id){ setSelected(null); setTitle(''); setContent(''); } }
    catch(e:any){ alert(e.message); }
  }

  return (
    <div className="min-h-screen grid grid-cols-12">
      <aside className="col-span-4 border-r p-4">
        <div className="flex items-center justify-between mb-3">
          <h1 className="text-lg font-semibold">Notes</h1>
          <button className="px-3 py-1 bg-blue-600 text-white rounded" onClick={() => { setSelected(null); setTitle(''); setContent(''); }}>
            New
          </button>
        </div>
        {loading ? <p>loading…</p> : err ? <p className="text-red-600">{err}</p> : (
          <ul className="space-y-2">
            {notes.map(n => (
              <li key={n.id} className={`p-2 rounded border ${selected?.id===n.id ? 'bg-blue-50 border-blue-300' : 'hover:bg-gray-50'}`}>
                <button className="w-full text-left" onClick={() => pick(n)}>
                  <div className="font-medium truncate">{n.title || 'Untitled'}</div>
                  <div className="text-xs text-gray-500">{new Date(n.updatedAt).toLocaleString()}</div>
                </button>
                <button className="text-xs text-red-600" onClick={() => destroy(n.id)}>delete</button>
              </li>
            ))}
          </ul>
        )}
      </aside>

      <main className="col-span-8 p-6">
        <div className="space-y-3">
          <input className="w-full border rounded p-2" placeholder="Title" value={title} onChange={e=>setTitle(e.target.value)} />
          <textarea className="w-full h-[60vh] border rounded p-2" placeholder="Write your note…" value={content} onChange={e=>setContent(e.target.value)} />
          <div className="flex gap-2">
            <button className="px-4 py-2 bg-green-600 text-white rounded" onClick={save}>
              {selected ? 'Update' : 'Create'}
            </button>
            {selected && (
              <button className="px-4 py-2 border border-red-600 text-red-600 rounded" onClick={() => destroy(selected.id)}>
                Delete
              </button>
            )}
          </div>
        </div>
      </main>
    </div>
  );
}
