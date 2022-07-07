create table rules_rate(
  id bigserial primary key not null,
  date_minimum DATE not null,
  date_maximum DATE not null,
  value_minimum float8 NOT NULL,
  value_maximum float8 not null,
  rate float8 not null,
  score_minimum float8 not null,
  score_maximum float8 not null,
  withdraw int not null
)