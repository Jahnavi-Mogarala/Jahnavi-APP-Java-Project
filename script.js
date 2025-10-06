// call this after pushScore local save (in submitQuizHandler)
function postScoreToServer(userKey, display, category, scoreVal, total) {
  fetch('/api/leaderboard', {
    method: 'POST',
    headers: {'Content-Type':'application/json'},
    body: JSON.stringify({
      user: userKey,
      displayName: display,
      category: category,
      score: scoreVal,
      total: total,
      timestamp: new Date().toISOString()
    })
  }).then(r => {
    if (!r.ok) console.warn('Server leaderboard post failed', r.status);
  }).catch(e => console.warn('Server leaderboard error', e));
}
